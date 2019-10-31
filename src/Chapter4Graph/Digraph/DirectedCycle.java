package Chapter4Graph.Digraph;


import edu.princeton.cs.algs4.Stack;

/**
 * 寻找图G中的有向环
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G){

    }

    public boolean hasCycle(){
        return false;
    }

    Iterable<Integer> cycle(){
        return null;
    }

}
