package Chapter4Graph.WeightedGraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Scanner;

/**
 * Prim算法的即时实现
 *      索引优先队列pq保存则当前循环中有效的横切边，在下一次循环开始时选出最小的横切边
 */
public class PrimeMST {

    private Edge[] edgesTo;                 //距离树最近的边
    private double[] distTo;                //边的权重 distTo[v]=edgesTo[v].weight()
    private boolean[] marked;
    private IndexMinPQ<Double> pq;            //有效的横切边（索引优先队列）

    public PrimeMST(EdgeWeightedGraph G){
        edgesTo=new Edge[G.V()];
        distTo=new double[G.V()];
        marked=new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        pq=new IndexMinPQ<>(G.V());
        distTo[0]=0.0;
        pq.insert(0,0.0);           //用顶点0和权重0初始化pq
        while(!pq.isEmpty()) {
            visit(G,pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G,int v){
        //将顶点v添加到数中，更新数据
        marked[v]=true;
        for (Edge e : G.adj(v)) {       //遍历顶点v所有未在树上的邻接边
            int w=e.other(v);
            if(marked[w]) continue;

            if(e.weight()<distTo[w]){
                //连接w和树的最佳边Edge变为e
                System.out.println(e.toString());

                edgesTo[w]=e;
                distTo[w]=e.weight();

                if(pq.contains(w)) pq.changeKey(w,distTo[w]);           //将有效的横切边存入索引优先队列中，以便下个循环取出最小值
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        Bag<Edge> edges = new Bag<>();
        for (Edge edge : edgesTo) {
            edges.add(edge);
        }
        return edges;
    }

    public double weight(){
        double weight=0.0;
        for (double dist : distTo) {
            weight+=dist;
        }
        return weight;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String filename=in.nextLine();
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("algs4-data/" + filename + ".txt"));
        PrimeMST primeMST = new PrimeMST(G);

        System.out.println("weight: "+primeMST.weight());
    }

}
