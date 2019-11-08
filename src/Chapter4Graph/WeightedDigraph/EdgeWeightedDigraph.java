package Chapter4Graph.WeightedDigraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Scanner;

/**
 * 加权有向图数据结构
 */

public class EdgeWeightedDigraph {

    private final int V;                //顶点总数
    private int E;                      //边总数
    private Bag<DirectedEdge>[] adj;    //边邻接表

    public EdgeWeightedDigraph(int V){
        this.V=V;
        this.E=0;
        adj= (Bag<DirectedEdge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i]=new Bag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(In in){
        this(in.readInt());
        int E=in.readInt();
        for (int e = 0; e < E; e++) {
            int from=in.readInt();
            int to=in.readInt();
            double weight=in.readDouble();
            DirectedEdge edge = new DirectedEdge(from, to, weight);
            addEdge(edge);
        }

    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : adj[v]) {
                bag.add(edge);
            }
        }
        return bag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileName=in.next();
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("algs4-data/" + fileName + ".txt"));

        System.out.println("顶点总数："+G.V());
        System.out.println("边总数： "+G.E());

        for (DirectedEdge edge : G.edges()) {
            System.out.println(edge);
        }
    }

}
