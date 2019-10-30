package Chapter4Graph.ConnectComponents;

import Chapter4Graph.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Scanner;

/**
 * 联通分量
 *
 * tinyG.txt
 * 13
 * 13
 * 0 5
 * 4 3
 * 0 1
 * 9 12
 * 6 4
 * 5 4
 * 0 2
 * 11 12
 * 9 10
 * 0 6
 * 7 8
 * 9 11
 * 5 3
 *
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;


    public CC(Graph G){                         //图预处理
        marked=new boolean[G.V()];
        id=new int[G.V()];
        for (int s = 0; s < G.V(); s++) {       //遍历所有为被标记的节点
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        id[v]=count;
        for (Integer w : G.adj(v)) {        //遍历顶点v的所有邻接节点
            if(!marked[w]){
                dfs(G,w);
            }
        }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph G=new Graph(new In("algs4-data/"+scanner.next()+".txt"));
//        int s= Integer.parseInt(scanner.next());
        CC cc = new CC(G);

        int M=cc.count();
        System.out.println(M+"个联通分量");

        Bag<Integer>[] components;
        components= (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i]=new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {       //将id=0的顶点添加到components[0]中
            components[cc.id(v)].add(v);
        }

        for (int i = 0; i < M; i++) {
            System.out.print("联通分量"+i+": ");
            for (Integer v : components[i]) {
                System.out.print(v+" ");
            }
            System.out.println();
        }


    }
}
