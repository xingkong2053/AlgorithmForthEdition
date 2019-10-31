package Chapter4Graph.Graph.Search;

import Chapter4Graph.Graph.Graph;
import basic.DataAbstraction.ImplementByArray.Stack;

/**
 * 使用深度优先搜索查找图的路径
 */
public class DepthFirstPaths {

    private boolean[] marked;           //
    private int[] edgeTo;               //从起点到一个顶点已知路径上最后一个顶点（在一条路径中，该顶点上一个顶点）
    private final int s;                //起点

    public DepthFirstPaths(Graph G,int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v]=true;                             //先将自身做标记
        for (Integer i : G.adj(v)) {                //遍历所有与节点v相邻的节点i
            if(!marked[i]){                         //如果i还没有做标记
                edgeTo[i]=v;
                dfs(G,i);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){                 //寻找s--->v路径
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x=v;x!=s;x=edgeTo[x]){              //迭代
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
