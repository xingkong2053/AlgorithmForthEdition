package Chapter2Sort;

/**
 * 希尔排序
 * 希尔排序基于插入排序
 *
 */

public class ShellSort extends Sort{

        public static void sort(Comparable[] a){
            int N=a.length;
            int h=1;

            while(h<N/3) h=3*h+1;           //1,4,13,40

            while(h>=1){
                //将数组变为h有序
                for(int i=h;i<N;i++){
                    for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
                        exch(a,j,j-h);
                    }
                }
                h=h/3;
            }

        }

}
