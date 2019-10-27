package basic.DataAbstraction.UnionFind;


/**
 * 1.5案例研究：union-find算法
 * quick-union
 */
public class QuickUnion {

    private int[] _id;              //使用数组存储分量
    private int _count;             //分量数量

    //以整数标记初始化n个触点
    public QuickUnion(int n) {

        //初始化连通分量
        _id = new int[n];

        for (int i = 0; i < n; i++)
            _id[i] = i;

        _count = n;
    }

    //在p和q之间添加一条连接
    public void union(int p, int q) {

        //将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot==qRoot) return;

        _id[pRoot]=qRoot;

        _count--;
    }

    //p（0到n-1）所在分量的标识符
    public int find(int p) {
        //找出分量名称
        while(p!=_id[p])
            p=_id[p];


        return p;
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
