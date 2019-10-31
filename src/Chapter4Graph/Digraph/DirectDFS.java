package Chapter4Graph.Digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * 有向图可达性（使用深度优先搜索）
 * 给出一个顶点s，找出G中所有能通过s达到的顶点
 */
public class DirectDFS {

    private boolean[] marked;

    public DirectDFS(Digraph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    //构造函数对有向图进行预处理
    public DirectDFS(Digraph G,Iterable<Integer> sources){
        marked=new boolean[G.V()];
        for (Integer source : sources) {
            if(!marked[source]) dfs(G,source);
        }
    }

    private void dfs(Digraph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]) dfs(G,w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Digraph G = new Digraph(new In("algs4-data/"+in.nextLine()+".txt"));

        Bag<Integer> sources = new Bag<>();
        String[] nums=in.nextLine().split(" ");
        for (String s : nums) {
            sources.add(Integer.parseInt(s));
        }

        DirectDFS reachable = new DirectDFS(G, sources);
        for (int v = 0; v < G.V(); v++) {
            if(reachable.marked(v)) StdOut.print(v+" ");
        }
        StdOut.println();

    }


}
