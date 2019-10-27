package Chapter2Sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import static Chapter2Sort.Sort.isSorted;

public class TestSort {


    public static void main(String[] args) {


        //读取需要生成double类型数的数量
        int N=Integer.parseInt(args[1]);

        Double[] a=new Double[N];

        for(int i=0;i<N;i++) {
            a[i]= StdRandom.uniform(0.0, 10.0);
        }

        Stopwatch timer=new Stopwatch();

        switch(args[0]){
            case "selection":SelectionSort.sort(a); break;
            case "insertion"   :InsertSort.sort(a); break;
            case "shell"    :ShellSort.sort(a);     break;
            default:StdOut.println("error");
        }
        double time=timer.elapsedTime();

        assert isSorted(a);

        System.out.println("the sort has cost :"+time+" second");

        for(double d:a) {
            StdOut.println(d);
        }
    }
}
