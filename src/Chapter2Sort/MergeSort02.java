package Chapter2Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 归并排序
 * 自底向上的归并排序
 */
public class MergeSort02 extends Sort {

    private static Comparable[] temp;

    public static void sort(Comparable[] a){
        int len=a.length;
        temp=new Comparable[len];
        for(int i=1;i<len;i*=2){                //1 2 4 8
            for(int first=0;first<len-i;first+=i*2){
                merge(a,first,first+i-1,Math.min(first+i*2-1,len-1));
            }
        }

    }

    /**
     * 假定a[first---middle] a[middle+1---last]俩数组是有序的，该方法是将这两个数组合并在一起
     * @param a
     * @param first
     * @param middle
     * @param last
     */
    private static void merge(Comparable[] a,int first,int middle,int last){
        int i=first,j=middle+1;

        for(int k=first;k<=last;k++){    //拷贝数组
            temp[k]=a[k];
        }

        for(int k=first;k<=last;k++){
            if(i>middle)                    a[k]=temp[j++];
            else if(j>last)                 a[k]=temp[i++];
            else if(less(temp[j],temp[i]))  a[k]=temp[j++];
            else                            a[k]=temp[i++];
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
        String[] a=new String[list.size()];
        list.toArray(a);

        sort(a);

        show(a);
    }

}
