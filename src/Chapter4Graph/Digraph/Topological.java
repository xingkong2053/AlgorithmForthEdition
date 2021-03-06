package Chapter4Graph.Digraph;


import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * 对图进行拓扑排序
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G){
        DirectedCycle cycleFinder = new DirectedCycle(G);           //第一遍深度优先搜索，判断是否为无环图
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);           //第二遍深度优先搜索
            order=dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){return order;}

    public boolean isDAG(){return order!=null;}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filename=in.next();
        String sp=in.next();
        SymbolDigraph g = new SymbolDigraph(filename, sp);

        Topological topo = new Topological(g.G());

        for (Integer i : topo.order()) {
            StdOut.println(g.name(i));
        }
    }

}
