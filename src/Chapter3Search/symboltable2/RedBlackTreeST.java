package Chapter3Search.symboltable2;

public class RedBlackTreeST<Key extends Comparable<Key>,Value> implements ST {

    private Node root;

    private static final boolean RED=true;
    private static final boolean BLACK=false;


    private class Node{
        public Key key;
        public Value value;
        public Node left,right;
        public int N;
        public boolean color;                                   //其父节点指向它的链接的颜色

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    /**
     * 判断指向该节点的链接是否为红链接
     * @param x
     * @return
     */
    private boolean isRed(Node x){
        if(x==null) return false;
        return x.color==RED;
    }

    private int size(Node x){
        if(x==null) return 0;
        return x.N;
    }

    /**
     * 左旋转h的右链接
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=size(h.left)+size(h.right)+1;
        return x;
    }

    //右旋转h的左链接
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=size(h.left)+size(h.right)+1;
        return x;
    }

    //颜色转换
    private void flipColors(Node h){
        h.color=RED;                    //指向父节点的链接变为红链接
        h.left.color=BLACK;             //指向子节点的链接均变为黑链接
        h.right.color=BLACK;
    }

    @Override
    public void put(Comparable comparable, Object o) {
        root=put(root, ((Key) comparable), ((Value) o));
        root.color=BLACK;

    }

    private Node put(Node h,Key key,Value val){
        if(h==null) return new Node(key,val,1,RED);

        int cmp=key.compareTo(h.key);
        if(cmp<0) h.left=put(h.left,key,val);
        else if(cmp>0) h.right=put(h.right,key,val);
        else h.value=val;

        if(isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
        if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
        if(isRed(h.left)&&isRed(h.right)) flipColors(h);
        h.N=size(h.left)+size(h.right)+1;

        return h;
    }

    @Override
    public Object get(Comparable comparable) {
        return null;
    }

    @Override
    public void delete(Comparable comparable) {

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
        return 0;
    }

    @Override
    public Comparable min() {
        return null;
    }

    @Override
    public Comparable max() {
        return null;
    }

    @Override
    public Comparable floor(Comparable comparable) {
        return null;
    }

    @Override
    public Comparable ceiling(Comparable comparable) {
        return null;
    }

    @Override
    public int rank(Comparable comparable) {
        return 0;
    }

    @Override
    public Comparable select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

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

    public static void main(String[] args) {

    }
}
