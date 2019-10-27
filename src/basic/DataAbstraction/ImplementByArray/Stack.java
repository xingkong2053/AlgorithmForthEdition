package basic.DataAbstraction.ImplementByArray;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 定义下压栈数据类型
 * 后进先出
 */

public class Stack<Item> implements Iterable<Item>{

    private Item[] _itemArray;
    private int _size;
    private int _capacity=10;
    private final int _addition=10;

    private class StackIterator implements Iterator<Item>{

        private int _s=_size;

        public boolean hasNext(){
            return (_s--)>1;
        }

        public Item next(){
            return _itemArray[_s];
        }

        public void remove(){

        }
    }


    public Stack(){
        _itemArray=(Item[])new Object[_capacity];
        _size=0;
    }

    public void push(Item item){
        _itemArray[_size++]=item;

        //动态数组
        if(_size==_capacity){
            Item[] temp=(Item[])new Object[_capacity+_addition];
            for(int i=0;i<_size;i++){
                temp[i]=_itemArray[i];
            }

            _itemArray=temp;

            _capacity+=_addition;
        }
    }

    public Item pop(){
        Item item=_itemArray[_size--];

//        if(_size==(_capacity-_addition)){
//            Item[] temp=(Item[])new Object[_capacity-_addition];
//            for(int i=0;i<_size;i++){
//                temp[i]=_itemArray[i];
//            }
//
//            _itemArray=temp;
//
//            _capacity-=_addition;
//        }

        return item;
    }

    public boolean isEmpty(){return _size==0;}

    public int size(){return _size;}

    //implements Iterable<Item>
    public StackIterator iterator(){
        return new StackIterator();
    }

    public static void main(String[] args){
        Stack<String> strStack=new Stack<>();               //创建一个存放字符串的栈

        while(!StdIn.isEmpty()){                            //不要用StdIn.hasNextLine
            if(StdIn.hasNextLine()) {
                strStack.push(StdIn.readString());
            }
        }

        StdOut.println("the Stack is empty:"+strStack.isEmpty());

        StdOut.println("the size of the Stack is: "+strStack.size());

        for (String s:strStack){
            StdOut.print(s+" ");
        }

        StdOut.println();


        StdOut.println("delete five words.");

        for(int i=0;i<5;i++)    strStack.pop();

        StdOut.println("the size of the Stack is: "+strStack._size);

        for (String s:strStack){
            StdOut.print(s+" ");
        }

        StdOut.println();
    }
}
