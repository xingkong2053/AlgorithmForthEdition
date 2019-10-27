package basic.DataAbstraction.ImplementByArray;


import edu.princeton.cs.algs4.*;

import java.util.Iterator;

/**
 * 定义队列数据类型
 * 先进先出：当使用foreach语句迭代访问队列中的元素时，元素的处理顺序就是它们被添加的顺序
 *
 */

public class Queue<Item> implements Iterable<Item> {

    private Item[] _items;          //数组用于存放队列中的元素
    private int _size;              //显示元素个数
    private int _capacity;          //队列的最大容量
    final private int _addition=10;

    private class QueueListIterator implements Iterator<Item>{

        private int _s=Queue.this._size;

        public boolean hasNext(){
            return _s-->0;                               //QueueListIterator._size
        }

        public Item next(){
            return _items[Queue.this._size-_s-1];          //先进先出
        }

        public void remove(){

        }
    }


    public Queue(){            //构造函数，初始化队列


        _capacity=10;
        _size=0;
        _items=(Item[]) new Object[_capacity];       //创建用于存放队列元素的数组

    }

    public Iterator<Item> iterator(){
        return new QueueListIterator();
    }

    public void enqueue(Item item){                 //添加元素
            _items[_size++] = item;

            if(_size==_capacity){
                Item[] temp=(Item[])new Object[_capacity+_addition];
                for(int i=0;i<_size;i++){
                    temp[i]=_items[i];
                }

                _items=temp;
                _capacity+=_addition;
            }
    }

    public Item dequeue(){                          //删除元素
        Item temp=_items[0];                                        //创建一个Item对象变量作为_items[0]的引用
        for(int i=1;i<_size;i++){
            _items[i-1]=_items[i];                                  //依次将_items中的元素前移一位（除了_items[0])
        }
        _size--;

        if(_size<_capacity-_addition){
            Item[] ItemArraytemp=(Item[])new Object[_capacity-_addition];
            for(int i=0;i<_size;i++){
                ItemArraytemp[i]=_items[i];
            }

            _items=ItemArraytemp;
            _capacity-=_addition;

        }

        return temp;
    }

    public boolean isEmpty(){return _size==0;}                      //判断是否为空队列

    public int size(){return _size;}                                //求队列中元素的数量


    public static void main(String...args){

        Queue<String> strQueue=new Queue<String>();        //创建一个容量为10的字符串队列

        while(!StdIn.isEmpty()){                            //不要用StdIn.hasNextLine
            if(StdIn.hasNextLine()) {
                strQueue.enqueue(StdIn.readString());
            }
        }

        StdOut.println("the size of the Queue is: "+strQueue._size);

        for (String s:strQueue){
            StdOut.print(s+" ");
        }

        StdOut.println();


        StdOut.println("delete five words.");

        for(int i=0;i<5;i++)    strQueue.dequeue();

        StdOut.println("the size of the Queue is: "+strQueue._size);

        for (String s:strQueue){
            StdOut.print(s+" ");
        }

        StdOut.println();






    }

}
