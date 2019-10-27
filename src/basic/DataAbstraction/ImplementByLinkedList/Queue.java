package basic.DataAbstraction.ImplementByLinkedList;


import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

//队列的链表实现
public class Queue <Item>implements Iterable<Item>{

    private int _size;
    private Node _first;
    private Node _last;

    private class Node{
        private Item item;
        private Node next;
    }

    private class QueueIterator implements Iterator<Item> {

        private Node currentNode=_first;

        public boolean hasNext(){
            return currentNode!=null;                       //not currentNode.next!=null;!!!
        }

        public Item next(){
            Item item=currentNode.item;
            currentNode=currentNode.next;
            return item;
        }

        public void remove(){}
    }

    public Queue(){
        _size=0;
    }

    public boolean isEmpty(){return _size==0;}

    public int getSize(){return _size;}

    public void enqueue(Item item){
        //入队：将元素添加到表尾
        Node temp=_last;
        _last=new Node();
        _last.item=item;
        _last.next=null;
        if(isEmpty())   _first=_last;
        else    temp.next=_last;
        _size++;
    }

    public Item dequeue(){
        //出队：从表头删除元素
        if(_first==null)    return null;
        Node temp=_first;
        _first=_first.next;
        _size--;
        return temp.item;
    }

    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

    public static void main(String[] args){

        Queue<String> strQueue=new Queue<>();

        System.out.println("the queue is empty:"+strQueue.isEmpty());

        //enqueue
        while(!StdIn.isEmpty()){
            strQueue.enqueue(StdIn.readString());
        }

        //getSize()
        System.out.println("the size of the queue is :"+strQueue.getSize());

        //Iterator
        for(String s:strQueue){
            System.out.print(s+" ");
        }
        System.out.println();

        //dequeue
        System.out.print("delete 3 elements: ");
        int num=3;
        while((num--)!=0){
            System.out.println(strQueue.dequeue());
        }

        //getSize()
        System.out.println("the size of the queue is :"+strQueue.getSize());

        //Iterator
        for(String s:strQueue){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
