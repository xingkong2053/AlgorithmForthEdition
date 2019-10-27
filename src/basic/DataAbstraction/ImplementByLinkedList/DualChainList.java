package basic.DataAbstraction.ImplementByLinkedList;


import java.util.Iterator;

//构造双向链表
public class DualChainList<Item> implements Iterable<Item> {

    private DoubleNode _first;                  //指向头结点
    private DoubleNode _last;                   //指向尾节点
    private int _size;
    private class DoubleNode{
        private Item _item;
        private DoubleNode _previous;
        private DoubleNode _next;

        DoubleNode(){}

        DoubleNode(Item item){
            _item=item;
        }
    }
    private class DualChainListIterator implements Iterator<Item>{

        private DoubleNode currentNode=_first;

        public boolean hasNext(){
            return currentNode!=null;
        }

        public Item next(){
            Item item=currentNode._item;
            currentNode=currentNode._next;
            return item;
        }

        public void remove(){}
    }

    public DualChainList(){_size=0;}

    public boolean isEmpty(){return _size==0;}

    public int getSize(){return _size;}

    public void insertFromHead(Item item){      //在头部插入一个新节点
        DoubleNode oldNode=_first;
        _first=new DoubleNode();
        _first._item=item;
        if(oldNode==null){                      //添加第一个节点
            _last=_first;
        }
        else{                                   //在原有的链表中插入节点
            _first._next=oldNode;
            oldNode._previous=_first;
        }

        _size++;
    }

    public Item deleteFromHead(){
        if(_first==null) return null;           //如果链表为空
        DoubleNode oldNode=_first;
        _first=_first._next;
        _first._previous=null;
        _size--;
        return oldNode._item;
    }

    public void insertFromTail(Item item){
        DoubleNode oldNode=_last;
        _last=new DoubleNode();
        _last._item=item;
        if(oldNode==null){
            _first=_last;
        }
        else{
            _last._next=null;
            _last._previous=oldNode;
            oldNode._next=_last;
        }

        _size++;
    }

    public Item deleteFromTail(){
        if(_first==null) return null;
        DoubleNode oldNode=_last;
        _last=_last._previous;
        _last._next=null;
        _size--;
        return oldNode._item;
    }

    public DoubleNode move(int index)throws
            IndexOutOfBoundsException,NullPointerException{   //移动到指定节点并返回该节点的引用，按下标
        if(index<0||index>_size-1){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if(_first==null){
            throw new NullPointerException("The linkList is empty.");
        }

        DoubleNode currentNode=_first;
        while((index--)!=0){
            currentNode=currentNode._next;
        }

        return currentNode;
    }

    public DoubleNode move(Item item){                            //移动到指定节点，按值
        DoubleNode currentNode=_first;
        while(currentNode._item!=item&&currentNode!=null){
            currentNode=currentNode._next;
        }

        if(currentNode==null){
            return null;
        }
        else{
            return currentNode;
        }

    }

    public void insertNodeAtFrontOf(int index,Item item){
        if(index==0)    insertFromHead(item);                   //在头结点前插入节点
        else {
            DoubleNode currentNode = move(index);
            DoubleNode newNode = new DoubleNode(item);
            newNode._previous = currentNode._previous;
            newNode._next = currentNode;
            currentNode._previous._next = newNode;
            currentNode._previous = newNode;
        }

        _size++;
    }

    public void insertNodeAtNextOf(int index,Item item){
        if(index==_size-1) insertFromTail(item);                //在尾节点后插入节点
        {
            DoubleNode currentNode = move(index);
            DoubleNode newNode = new DoubleNode(item);
            newNode._previous=currentNode;
            newNode._next=currentNode._next;
            currentNode._next._previous=newNode;
            currentNode._next=newNode;
        }

        _size++;
    }

    public Item deleteNode(int index){

        if(index==0){
            _size--;
            return deleteFromHead();
        }
        else if(index==_size-1){
            _size--;
            return deleteFromTail();
        }
        else{
            DoubleNode currentNode=move(index);
            currentNode._previous._next=currentNode._next;
            currentNode._next._previous=currentNode._previous;
            _size--;
            return currentNode._item;
        }
    }

    public DualChainListIterator iterator(){
        return new DualChainListIterator();
    }

}
