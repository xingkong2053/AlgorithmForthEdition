package Chapter4Graph.WeightedGraph;

/**
 * 加权边数据结构
 */
public class Edge implements Comparable<Edge>{

    private final int v;                    //顶点之一
    private final int w;                    //顶点二
    private final double weight;            //边的权重

    Edge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public double weight(){                 //权重
        return weight;
    }

    public int either(){                    //边的顶点之一
        return v;
    }

    public int other(int vertex){           //边的另一个顶点
        if(vertex==v) return w;
        else if(vertex==w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge that) {       //比较边
        if(this.weight()<that.weight()) return -1;
        else if(this.weight()>that.weight()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f",v,w,weight);
    }
}
