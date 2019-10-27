package Chapter2Sort;

/**
 * 归并排序
 * 自顶向下的归并排序使用了递归思想
 */
public class MergeSort01 extends Sort {

    private static Comparable[] temp;

    public static void sort(Comparable[] a){    //自顶向下排序
        temp=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int first,int last){
        if(last<=first) return;
        int mid=(first+last)/2;
        sort(a,first,mid);                //左侧排序
        sort(a,mid+1,last);         //右侧排序
        merge(a,first,mid,last);          //归并
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

        for(int k=first;k<last;k++){    //拷贝数组
            temp[k]=a[k];
        }

        for(int k=first;k<last;k++){
            if(i>middle)                    a[k]=temp[j++];
            else if(j>last)                 a[k]=temp[i++];
            else if(less(temp[j],temp[i]))  a[k]=temp[j++];
            else                            a[k]=temp[i++];
        }
    }

}
