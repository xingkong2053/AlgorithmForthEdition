package basic.DataAbstraction.ImplementByLinkedList;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

    private Node _first;        //栈顶
    private int _size;          //元素数量
    private class Node{
        //定义节点镶套类
        Item item;
        Node next;

        public Node(){
            next=null;
            item=null;
        }
    }

    private class StackIterator implements Iterator<Item> {

        private Node currentNode=_first;

        public boolean hasNext(){
                return currentNode!=null;
        }

        public Item next(){
            Item item=currentNode.item;
            currentNode=currentNode.next;
            return item;
        }

        public void remove(){}
    }

    public Stack(){
        _size=0;
    }

    public boolean isEmpty(){return _size==0;}

    public int getSize(){return _size;}

    public void push(Item item){
        //向栈顶添加元素：从头部插入一个节点
        Node oldNode=_first;

        //建立一个新节点，并作为栈顶
        _first=new Node();
        _first.item=item;
        _first.next=oldNode;
        _size++;
    }

    public Item pop(){
        //从栈顶删除元素：从头部删除一个节点
        if(_first==null) return null;
        Item item = _first.item;
        _first = _first.next;
        _size--;
        return item;

    }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    public static void main(String[] args){

        Stack<String> strStack=new Stack<>();

        //测试isEmpty()
        System.out.println("strStack is empty: "+strStack.isEmpty());

        //push()
        while(!StdIn.isEmpty()){                                    //
            strStack.push(StdIn.readString());
        }

        //size()
        System.out.println("the size of this Stack is:"+strStack.getSize());

        //Iterator
        System.out.println("strStack:");
        for(String s:strStack) {
            System.out.print(s+" ");
        }
        System.out.println();

        //pop()
        System.out.println("pop two words.");
        System.out.println(strStack.pop());
        System.out.println(strStack.pop());

        //pop之后再次输出strStack内容
        System.out.println("the size of this Stack is:"+strStack.getSize());

        //Iterator
        System.out.println("strStack:");
        for(String s:strStack) {
            System.out.print(s+" ");
        }
        System.out.println();

    }


}
