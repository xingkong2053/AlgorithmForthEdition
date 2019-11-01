package Chapter4Graph.Digraph;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 基于深度优先搜索的顶点排序
 * 3种遍历方式
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;                         //所有顶点的前序排列
    private Queue<Integer> post;                        //所有顶点的后序排列
    private Stack<Integer> reversePost;                 //所有顶点的逆后续排列

    public DepthFirstOrder(Digraph G){
        pre=new Queue<>();
        post=new Queue<>();
        reversePost=new Stack<>();
        marked=new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G,int v){
        pre.enqueue(v);                     //前序遍历在递归开始之前把顶点加入到队列之中

        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G,w);
            }
        }

        post.enqueue(v);                    //后序遍历在递归结束时把顶点加入到队列中
        reversePost.push(v);                //逆后序遍历把顶点加入到栈中
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
