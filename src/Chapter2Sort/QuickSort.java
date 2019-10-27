package Chapter2Sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 快速排序
 *
 */
public class QuickSort extends Sort {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);       //随机打乱元素，消除元素对输入的依赖
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int first,int last){
//        if(first>=last) return;             //如果子数组只有一个元素则不用排序
        if(first+10>=last) {                    //对于小的数组应用插入排序可以提高性能
            InsertSort.sort(a,first,last);
            return;
        }
        int j=partition(a,first,last);
        sort(a,first,j-1);
        sort(a,j+1,last);
    }

    /**
     * 快速排序切分
     * 功能：设置a[0]为比较元素，遍历数组，将比a[0]小的所有元素统一放在a[0]的左侧，比a[0]大的所有元素放在a[0]右侧
     * @param a
     * @param first
     * @param last
     * @return
     */
    private static int partition(Comparable[] a,int first,int last){
        int i=first;        //左侧扫描指针
        int j=last+1;       //右侧扫描指针
        Comparable v=a[first];      //切分元素

        while(true){
            while(less(a[++i],v)) if(i==last) break;     //至左向右遍历数组元素，如果有元素比a[0]大，则停下
            while(less(v,a[--j])) if(j==first) break;    //至右向左遍历数组元素，如果有元素比a[0]小，则停下
            if(i>=j) break;                              //指针ij相遇时主循环退出
            exch(a,i,j);
        }
        exch(a,first,j);        //最后将a[0]放在两个子数组的中间
        return j;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("输入字符串：");

        String s;
        while (!(s = in.next()).equals("exit")) {
            list.add(s);
        }
        System.out.println("--------");
        String[] a=new String[list.size()];
        list.toArray(a);

        sort(a);

        show(a);
    }
}
