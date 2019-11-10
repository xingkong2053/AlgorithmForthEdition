package Chapter4Graph.WeightedDigraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

/**
 * 求加权有向图最短路径，Dijkstra算法
 * 使用一个索引优先队列来维护所有已遍历的节点的下一个节点
 * 将顶点v加入树中：将distTo[v]改为顶点s到顶点v的最短距离
 */
public class DijkstraSP {

    private DirectedEdge[] edgesTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    /**
     * 预处理函数，求以s为起点加权有向图G的最短路径树
     * @param G
     * @param s
     */
    public DijkstraSP(EdgeWeightedDigraph G,int s){
        edgesTo=new DirectedEdge[G.V()];
        distTo=new double[G.V()];
        pq=new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0.0;
        pq.insert(s,0.0);
        while(!pq.isEmpty()){
            relax(G,pq.delMin());               //将dist[]最小的非树顶点放松并加入树中
        }
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for (DirectedEdge edge : G.adj(v)) {
            int w=edge.to();
            if(distTo[w]>distTo[v]+ edge.weight()){
                distTo[w]=distTo[v]+ edge.weight();
                edgesTo[w]=edge;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

    //从顶点s到v的距离，如果不存在则路径无穷大
    public double distTo(int v){return distTo[v];}

    //是否存在从顶点s到v的路径
    public boolean hasPathTo(int v){return distTo[v]<Double.POSITIVE_INFINITY;}

    //从顶点s到v的路径，如果不存在则为null
    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path=new Stack<>();
        for(DirectedEdge e=edgesTo[v];e!=null;e=edgesTo[e.from()]){
            path.push(e);
        }
        return path;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file=in.next();
        int s=Integer.parseInt(in.next());
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("algs4-data/" + file + ".txt"));
        DijkstraSP sp = new DijkstraSP(G, s);//以s为顶点对图G构建最小生成树
        for (int v = 0; v < G.V(); v++) {
            if (sp.hasPathTo(v)) {
                Iterable<DirectedEdge> des = sp.pathTo(v);
                System.out.print(v+" ");
                for (DirectedEdge de : des) {
                    System.out.print(de.from()+"--->"+de.to()+" ");
                }
                System.out.println();
            }
            else{
                System.out.println("从0到"+v+"没有路径");
            }
        }

    }

}
