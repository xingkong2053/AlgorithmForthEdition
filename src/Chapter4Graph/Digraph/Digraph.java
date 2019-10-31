package Chapter4Graph.Digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 有向图
 */
public class Digraph {

    private final int V;                    //顶点
    private int E;                          //边
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V=V;
        this.E=0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v]=new Bag<>();
        }
    }

    public Digraph(In in){
        this(in.readInt());             //读取V并将图初始化
        int E=in.readInt();             //读取E
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);               //添加一条连接他们的边
        }
    }

    public int V(){return V;}
    public int E(){return E;}

    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){                   //反转图
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w : adj[v]) {
                addEdge(w,v);
            }
        }
        return R;
    }
}
