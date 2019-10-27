package Chapter2Sort;


import java.util.ArrayList;
import java.util.Timer;

/**
 * 插入排序
 *
 */

public class InsertSort extends Sort{


    public static void sort(Comparable[] a){
        sort(a,0,a.length);
    }

    public static void sort(Comparable[] a,int first,int last){
       //将a[]按升序排列
       for(int i=first+1;i<last;i++){
           //将a[i]插入到a[i-1]、a[i-2]、a[i-3]之中
           for(int j=i;j>0&&less(a[j],a[j-1]);j--){ //将a[i]插入到a[i-1]...a[0]之中合适的位置
               exch(a,j,j-1);
           }
        }
    }


}
