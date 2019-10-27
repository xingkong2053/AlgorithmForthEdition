package basic.DataAbstraction.priorityqueue;

import java.util.Scanner;

/**
 * 优先队列有一个基于堆的完全二叉树表示，储存于数组pq[1...len]中，pq[0]没有使用
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>>/*优先队列的元素类型必须是实现了Comparable接口的类*/ {

    private Key[] priorityQueue;    //二叉堆元素存放位置
    private int len=0;              //储存于priorityQueue[1--N]中

    //辅助方法
    private boolean less(int i,int j){
        return priorityQueue[i].compareTo(priorityQueue[j])<0;
    }
    private void exchange(int i,int j){
        Key tmp=priorityQueue[i];
        priorityQueue[i]=priorityQueue[j];
        priorityQueue[j]=tmp;
    }
    //由下至上的堆有序化（上浮）
    private void swim(int k){
        while (k > 1 && less(k / 2, k)) {
            exchange(k/2,k);
            k=k/2;
        }
    }
    //由上至下的堆有序化（下沉）的实现
    private void sink(int k){
        while(2*k<=len){
            int j=k*2;
            if(j<len&&less(j,j+1)) j++;     //选择两个子元素pq[2*k]/pq[2*k+1]中的大者
            if(!less(k,j)) break;               //判断当前元素是否小于该子元素，如果不是则不再下沉（跳出循环）
            exchange(k,j);                      //下沉操作
            k=j;
        }
    }

    public MaxPQ(){ }
    //创建一个初始容量为max的优先队列
    public MaxPQ(int max){
        priorityQueue= (Key[]) new Comparable[max + 1];
    }
    //用a[]中的元素创建一个优先队列
    public MaxPQ(Key[] a){ }

    //向优先队列中插入一个元素
    void insert(Key v){
        priorityQueue[++len]=v;
        swim(len);              //将最后一个元素上浮到合适的位置
    }

    //返回最大元素
    Key getMax(){
        return priorityQueue[1];
    }

    //删除并返回最大元素
    Key delMax(){
        Key max=priorityQueue[1];
        exchange(1,len--);              //将根节点与最后一个节点交换
        priorityQueue[len+1]=null;          //防止对象游离
        sink(1);                        //恢复堆有序性
        return max;
    }

    //返回队列是否为空
    boolean isEmpty(){
        return len==0;
    }

    //返回优先队列中的元素个数
    int size(){
        return len;
    }

    public static void main(String[] args) {
        MaxPQ<String> strPQ=new MaxPQ<>(50);

        Scanner in = new Scanner(System.in);
        String str="";
        while(!(str=in.next()).equals("exit")){
            if(str.equals("$get")){
                System.out.println("the max string is: "+strPQ.delMax());
                continue;
            }
            strPQ.insert(str);
        }
    }
}
