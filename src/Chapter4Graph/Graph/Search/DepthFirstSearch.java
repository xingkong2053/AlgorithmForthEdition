package Chapter4Graph.Graph.Search;

import Chapter4Graph.Graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * 图的深度优先搜索
 */
public class DepthFirstSearch implements Search {

    private boolean[] marked;                       //数组为顶点做标记
    private int count;

    //找到与起点s联通的所有顶点
    public DepthFirstSearch(Graph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);                   //开始搜索
    }

    private void dfs(Graph G,int v){
        marked[v]=true;                 //将该节点做标记
        count++;                        //计数
        for (Integer w : G.adj(v)) {
            if(!marked[w]) dfs(G,w);    //递归访问它的所有没有被标记过的邻居顶点
        }
    }

    @Override
    public Boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph G=new Graph(new In(scanner.next()));
        int s= Integer.parseInt(scanner.next());
        Search search = new DepthFirstSearch(G, s);

        for (int i = 0; i < G.V(); i++) {
            if(search.marked(i))
                StdOut.print(i+" ");
        }
        StdOut.println();
    }
}
