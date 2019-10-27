package Chapter3Search.symboltable2;

import java.util.Scanner;

/**
 * 二叉查找树
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>,Value> implements ST{

    private Node root;          //二叉查找树的根节点

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;        //指向左子树和右子树的链接
        private int N;                  //节点计数器，以该节点为根的子树中的节点的总数

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    @Override
    public void put(Comparable comparable, Object o) {
        root=put(root, ((Key) comparable), ((Value) o));
    }

    private Node put(Node x,Key key,Value val){
        if(x==null) return new Node(key,val,1);         //递归终止条件
        int cmp=key.compareTo(x.key);                       //判断是插入在左子树中还是右子树中
        if(cmp<0) x.left=put(x.left,key,val);
        else if(cmp>0) x.right=put(x.right,key,val);
        else x.value=val;                                   //如果key存在于以x为节点的子树中则更新它的值
        x.N=size(x.left)+size(x.right)+1;                   //更新节点计数器的值
        return x;                                           //返回这个节点的引用，相当于让父节点与更新后的子树建立链接
    }

    @Override
    public Value get(Comparable key) {
        return get(root, ((Key) key));
    }

    private Value get(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if(cmp>0) return get(x.right,key);
        else return x.value;
    }

    @Override
    public void delete(Comparable comparable) {
        root=delete(root, ((Key) comparable));
    }

    private Node delete(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) x.left=delete(x.left,key);
        else if(cmp>0) x.right=delete(x.right,key);
        else{
            if(x.right==null) return x.left;
            if(x.left==null) return x.right;
            Node t=x;
            x=min(t.right);                                                     //将x指向它的后继节点，即t右子树中的最小值
            x.right=deleteMin(t.right);                                         //t的右子树删除最小值（节点x），并将它挂在x的右边
            x.left=t.left;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    @Override
    public boolean contains(Comparable comparable) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x){
        if(x==null) return 0;
        else return x.N;
    }

    @Override
    public Comparable min() {
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);             //如果一个树非空，那么该树最小值对应的节点一定在左子树中
    }

    @Override
    public Comparable max() {
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }

    /**
     * 向下取整
     * @param comparable
     * @return
     */
    @Override
    public Comparable floor(Comparable comparable) {
        Node x=floor(root, ((Key) comparable));
        if(x==null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        else if(cmp<0) return floor(x.left,key);     //key小于父节点的键，则小于key的最大键一定出现在父节点的左子树中
        else{                                        //key大于父节点的键，则需要检查父节点的右子树中是否有小于key的最大键，如果没有则父节点键就是小于key的最大键
            Node t=floor(x.right,key);
            if(t!=null) return t;
            else return x;
        }
    }

    /**
     * 向上取整
     * @param comparable
     * @return
     */
    @Override
    public Comparable ceiling(Comparable comparable) {
        Node x=ceiling(root, ((Key) comparable));
        if(x==null) return null;
        return x.key;
    }

    private Node ceiling(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        else if(cmp>0) return ceiling(x.right,key);
        else{
            Node t=ceiling(x.left,key);
            if(t!=null) return t;
            return x;
        }
    }

    /**
     * 返回键key的索引
     * @param comparable
     * @return
     */
    @Override
    public int rank(Comparable comparable) {
        return rank(root, ((Key) comparable));
    }

    private int rank(Node x,Key key){
        //返回以x为根节点的子树中小于x.key的键的数量
        if(x==null) return 0;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return rank(x.left,key);
        else if(cmp>0) return 1+size(x.left)+rank(x.right,key);
        else return size(x.left);
    }

    @Override
    public Comparable select(int k) {
        return select(root,k).key;
    }

    private Node select(Node x,int k){
        //返回排名为k的节点
        if(x==null) return null;
        int t=size(x.left);
        if(t>k) return select(x.left,k);
        else if(t>k) return select(x.right,k-t-1);
        else return x;
    }

    @Override
    public void deleteMin() {
        root=deleteMin(root);
    }

    private Node deleteMin(Node x){                                     //递归删除最小值
        if(x.left==null) return x.right;                                //如果x的左节点为空（已为着x为最小节点），则将x的右节点与x的父节点建立连接
        x.left= deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    @Override
    public void deleteMax() {
        root=deleteMax(root);
    }

    private Node deleteMax(Node x){
        if(x.right==null) return x.left;
        x.right=deleteMax(x.right);
        x.N=size(x.right)+size(x.left)+1;
        return x;
    }

    @Override
    public int size(Comparable lo, Comparable hi) {
        return 0;
    }

    @Override
    public Iterable keys(Comparable lo, Comparable hi) {
        return null;
    }

    @Override
    public Iterable keys() {
        return null;
    }

    public void print(){
        System.out.println("***************************************");
        print(root,0);
        System.out.println("***************************************");
    }

    private void print(Node x,int floor){
        if(x==null) return ;
        print(x.left,floor+1);

        for (int i = 0; i < floor; i++) {
            System.out.print("----");
        }
        System.out.println(x.key+" "+x.value);

        print(x.right,floor+1);
    }


    public static void main(String[] args) {
        BST<String, Integer> sibst = new BST<>();

        int i=0;
        String str;
        boolean flag=true;
        Scanner in = new Scanner(System.in);
        String[] words;

        while(flag){
            str=in.nextLine();
            if(str.equals("")) continue;
            words = str.split(" ");
            switch (words[0]){
                case "$exit": {
                    flag=false;
                    break;
                }
                case "$add":{
                    sibst.put(words[1],i++);
                    break;
                }
                case "$del":{
                    sibst.delete(words[1]);
                    break;
                }
                case "$show":{
                    sibst.print();
                    break;
                }
                default:{
                    System.out.println("错误命令");
                }
            }
        }
    }

}
