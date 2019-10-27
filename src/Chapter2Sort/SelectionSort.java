package Chapter2Sort;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

/**
 * 选择排序 冒泡排序
 *
 *
 */
public class SelectionSort extends Sort {

    public static void sort(Comparable[] a){

        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){             //这个循环用于找出数最小的那一项
                if(less(a[j],a[min])) min=j;
            }
            exch(a,i,min);                      //将那一项与第一项交换，即将最小的那个数放在最前面
        }
    }

    public static void main(String[] args){


        ArrayList<String> strList=new ArrayList<>();

        while(!StdIn.isEmpty()){
            strList.add(StdIn.readString());
        }


        String[] a=new String[strList.size()];

        strList.toArray(a);

        sort(a);

        assert isSorted(a);

        show(a);
    }

}
