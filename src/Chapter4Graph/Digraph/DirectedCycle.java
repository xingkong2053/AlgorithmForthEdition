package Chapter4Graph.Digraph;


import edu.princeton.cs.algs4.Stack;

/**
 * 寻找图G中的有向环
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;           //有向环中的所有顶点
    private boolean[] onStack;              //标记递归调用期间栈上的所有顶点，在递归调用结束后将其设置为false

    public DirectedCycle(Digraph G){
        onStack=new boolean[G.V()];
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]) dfs(G,v);
        }
    }

    private void dfs(Digraph G,int v){
        marked[v]=true;
        onStack[v]=true;
        for (Integer w : G.adj(v)) {
            if(this.hasCycle()) return;
            else if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
            else if(onStack[w]){
                cycle=new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    Iterable<Integer> cycle(){
        return cycle;
    }

}
