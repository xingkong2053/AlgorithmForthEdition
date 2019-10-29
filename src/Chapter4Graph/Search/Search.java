package Chapter4Graph.Search;

import Chapter4Graph.Graph;

public interface Search {

    //v和s是否联通
    Boolean marked(int v);
    //与s联通的顶点总数
    int count();
}
