package Chapter4Graph.Digraph.StronglyConnectedComponents;

import Chapter4Graph.Digraph.DepthFirstOrder;
import Chapter4Graph.Digraph.Digraph;

/**
 * 使用Kosaraju算法计算有向图的强连通性
 */
public class KosarajuSCC {

    private boolean[] marked;
    private int[] id;                           //强连通分量的标识符
    private int count;                          //强连通分量的数量


    public KosarajuSCC(Digraph G){
        marked=new boolean[G.V()];
        id=new int[G.V()];

        DepthFirstOrder dfo = new DepthFirstOrder(G);
        for (Integer v : dfo.reversePost()) {       //按照G的反向图的逆后序排列遍历节点
            if (!marked[v]) {
                dfs(G,v);
                count++;
            }
        }
    }

    public void dfs(Digraph G,int v){
        marked[v]=true;
        id[v]=count;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v,int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
