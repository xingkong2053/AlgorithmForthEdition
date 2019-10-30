package Chapter4Graph.ConnectComponents;

import Chapter4Graph.Graph;

/**
 * 联通分量
 *
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;


    public CC(Graph G){

    }

    private void dfs(Graph G,int v){

    }

    private boolean connected(int v,int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
