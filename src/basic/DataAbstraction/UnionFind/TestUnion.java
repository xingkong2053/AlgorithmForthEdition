package basic.DataAbstraction.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TestUnion {

    public static void main(String[] args){

        Stopwatch timer=new Stopwatch();

        int num= StdIn.readInt();                       //读取触点数量

//        UnionFind union=new UnionFind(num);
        QuickUnion union=new QuickUnion(num);
//        WeightedQuickUnion union=new WeightedQuickUnion(num);

        while(!StdIn.isEmpty()){

            //读取整数对
            int p=StdIn.readInt();
            int q=StdIn.readInt();

            //如果以联通则忽略
            if(union.isConnected(p,q)) continue;

            union.union(p,q);                           //归并分量

            //StdOut.println(p+" "+q);                    //打印连接

        }

        double time=timer.elapsedTime();

        StdOut.println(union.count()+" components");

        StdOut.println("the program has run "+time+" seconds");
    }
}
