package Chapter4Graph.Search;

import Chapter4Graph.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


/**
 * 广度优先搜索
 *
 */
public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;                                //起点

    public BreadthFirstPaths(Graph G,int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        bfs(G,s);
    }

    /**
     * 广度优先搜索算法
     * @param G
     * @param s
     */
    private void bfs(Graph G,int s){
        Queue<Integer> queue = new Queue<>();
        marked[s]=true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v=queue.dequeue();
            for (Integer w : G.adj(v)) {
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){return marked[v];}

    public Iterable<Integer> pathTo(int v){                 //寻找s--->v最短路径
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int w=v;w!=s;w=edgeTo[w]){
            path.push(w);
        }
        path.push(s);
        return path;
    }

}
