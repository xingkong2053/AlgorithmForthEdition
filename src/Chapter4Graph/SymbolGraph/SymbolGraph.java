package Chapter4Graph.SymbolGraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * 符号图数据类型
 * 核心思想是建立 符号（字符串）和整数的一一映射
 *
 */
public class SymbolGraph {
    private ST<String,Integer> st;      //符号名-->索引
    private String[] keys;              //索引-->符号名
    private Graph G;

    public SymbolGraph(String stream,String sp){
        st=new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {                      //第一遍读取文件
            String[] strings=in.readLine().split(sp);   //读取字符串

            for (String s : strings) {
                if(!st.contains(s))                     //将符号s加入到符号表中
                    st.put(s,st.size());
            }
        }

        keys=new String[st.size()];
        for (String key : st.keys()) {
            keys[st.get(key)]=key;
        }

        G=new Graph(st.size());                         //第二遍读取文件
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] strings=in.readLine().split(sp);   //读取字符串
            int v=st.get(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                G.addEdge(v,st.get(strings[i]));
            }
        }
    }

    public boolean contain(String s){return st.contains(s);}

    public int index(String s){return st.get(s);}

    public String name(int i){return keys[i];}

    public Graph G(){return G;}

    public static void main(String[] args) {
        SymbolGraph symbolGraph = new SymbolGraph("algs4-data/routes.txt", " ");

        Graph g=symbolGraph.G();

        System.out.println("**************图结构如下************");
        for (int v = 0; v < g.V(); v++) {
            System.out.print("vertex "+symbolGraph.name(v));
            for (Integer i : g.adj(v)) {
                System.out.print("-->"+symbolGraph.name(i));
            }
            System.out.println();
        }
        System.out.println("**********************************");
    }

}
