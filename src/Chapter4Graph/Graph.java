package Chapter4Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 使用邻接表数组表示无向图
 * G(V,E) V:顶点的数目，E:边的的数目
 */
public class Graph {

    //顶点的数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V=V;this.E=0;
        adj= ((Bag<Integer>[]) new Bag[V]);     //创建邻接表
        for(int v=0;v<V;v++){
            adj[v]=new Bag<>();                 //将所有的链表初始化
        }
    }

    public Graph(In in){
        this(in.readInt());             //读取V并将图初始化
        int E=in.readInt();             //读取E
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);               //添加一条连接他们的边
        }
        System.out.println("**************图结构如下************");
        for (int v = 0; v < V; v++) {
            System.out.print("vertex "+v);
            for (Integer i : adj(v)) {
                System.out.print("-->"+i);
            }
            System.out.println();
        }
        System.out.println("**********************************");

    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);                      //将w添加到v的链表中
        adj[w].add(v);                      //将v添加到w的链表中
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
