package Chapter2Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 堆排序实现
 *
 */
public class HeapSort extends Sort {


    public static void sort(Comparable[] a){
        int len=a.length-1;
        //通过下沉sink()构造有序堆
        for(int k=len/2;k>=1;k--){
            sink(a,k,len);
        }

        //下沉排序逐渐销毁堆
        while(len>1){
            exch(a,1,len--);
            sink(a,1,len);
        }
    }

    //二叉堆下沉操作
    public static void sink(Comparable[] a,int k,int len){
        while(2*k<=len){
            int j=k*2;
            if(j<len&&less(a[j],a[j+1])) j++;
            if(less(a[j],a[k])) break;
            exch(a,j,k);
            k=j;
        }
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
        String[] a=new String[list.size()+1];
        int i=0;
        for (String s1 : list) {
            a[++i]=s1;
        }

        sort(a);

        show(a);
    }
}
