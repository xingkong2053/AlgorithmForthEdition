package Chapter4Graph.WeightedGraph;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;

/**
 * 最小生成树Prime算法的延时实现
 *
 */
public class LazyPrimeMST {

    private boolean[] marked;       //最小生成树的顶点,如果顶点v已加入到最小生成树中则将marked[v]标记为true
    private Queue<Edge> mst;        //最小生成树的边
    private MinPQ<Edge> pq;         //横切边（包括失效的边）


    //构造函数
    public LazyPrimeMST(EdgeWeightedGraph G){
        pq=new MinPQ<Edge>();
        marked=new boolean[G.V()];
        mst=new Queue<Edge>();
        visit(G,0);
        while(!pq.isEmpty()){
            Edge e=pq.delMin();
            int v=e.either(),w=e.other(v);
            if(marked[v]&&marked[w]) continue;  //跳过失效的边
            mst.enqueue(e);                     //将边添加到最小生成树中
            if(!marked[v]) visit(G,v);
            if(!marked[w]) visit(G,w);
        }
    }


    private void visit(EdgeWeightedGraph G,int v){
        //标记顶点v并将所有连接v和未被标记的顶点的边加入pq
        marked[v]=true;
        for (Edge e : G.adj(v)) {
            if(!marked[e.other(v)]) pq.insert(e);
        }
    }

    //最小生成树的所有边
    public Iterable<Edge> edges(){
        return mst;
    }

    //最小生成树的权重
    public double weight(){
        double weight=0.0;
        for (Edge e : mst) {
            weight+=e.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String filename=in.nextLine();
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("algs4-data/" + filename + ".txt"));
        LazyPrimeMST mst = new LazyPrimeMST(G);
        System.out.println("---------------------原图---------------------");
        for (Edge e : G.edges()) {
            System.out.println(e.toString());
        }
        System.out.println("----------------------------------------------");
        System.out.println("---------------------最小生成树---------------------");
        for (Edge e : mst.edges()) {
            System.out.println(e.toString());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("树的权重："+mst.weight());

    }
}
