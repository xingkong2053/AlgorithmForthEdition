package basic.DataAbstraction.UnionFind;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 1.5案例研究：union-find算法
 * quick-find
 */
public class UnionFind {

    private int[] _id;              //使用数组存储分量
    private int _count;             //分量数量

    //以整数标记初始化n个触点
    public UnionFind(int n) {

        //初始化连通分量
        _id = new int[n];

        for (int i = 0; i < n; i++)
            _id[i] = i;

        _count = n;
    }

    //在p和q之间添加一条连接
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        //如果p和q在同一个分量中，则不做任何处理
        if (pId == qId) return;

        //将p所在分量中的所有元素全部添加到q所在分量中
        for (int i = 0; i < _id.length; i++) {
            if (_id[i] == pId) _id[i] = qId;
        }

        _count--;
    }

    //p（0到n-1）所在分量的标识符
    public int find(int p) {
        return _id[p];
    }

    //如果p和q在同一个分量中则返回true
    public boolean isConnected(int p, int q) {
        return _id[p] == _id[q];
    }

    //联通分量的数量
    public int count() {
        return _count;
    }


}
