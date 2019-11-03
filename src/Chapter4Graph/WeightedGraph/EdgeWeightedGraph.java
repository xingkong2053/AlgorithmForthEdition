package Chapter4Graph.WeightedGraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V){        //创建一个含有V顶点的空图
        this.V=V;
        this.E=0;
        adj= ((Bag<Edge>[]) new Bag[V]);
        for (int v = 0; v < V; v++) {
            adj[v]=new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int E=in.readInt();
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            double weight=in.readDouble();
            addEdge(new Edge(v,w,weight));
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){
        int v=e.either(),w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b=new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if(e.other(v)>v) b.add(e);      //保证不重复添加边
            }
        }
        return b;
    }
}
