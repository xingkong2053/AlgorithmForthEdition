package Chapter2Sort;


import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法
 *
 */
public class Sort {

    public static void sort(Comparable[] a){

    }

    public  static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public  static void show(Comparable[ ] a){
        for(Comparable c:a){
            StdOut.print(c+" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
