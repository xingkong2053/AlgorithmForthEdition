package basic.DataAbstraction.ImplementByArray;

import edu.princeton.cs.algs4.*;

import java.util.Iterator;
/**
 * 定义背包数据类型
 * 背包是一种不支持删除元素的数据类型
 * 作用：收集元素，并迭代遍历所有的元素
 * 背包不讲究元素在其中的顺序
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item>{

    private Item[] _items;                          //用于储存元素的数组
    private int _size=0;                            //背包中元素的数量
    private final int _capacity;                    //容量


    //实现迭代器类型iterator
    private class ListIterator implements Iterator<Item>{       //内部类，该类用于实现迭代器类中的方法

        private int _size=Bag.this._size;

        /**
         *              while(listitertor.hasNext()){
         *                  next=listitertor.next()
         *              }
         * @return
         */

        public boolean hasNext(){
            return _size-->0;
        }

        public Item next(){
            return _items[_size];
        }

        public void remove(){}

    }


    //创建一个空背包
    Bag(int capacity){

        _capacity=capacity;
        _items=(Item[])new Object[_capacity];   //创建一个泛型数组需要使用类型转换
                                                //错误：_items=new Item[_capacity];

    }

    //添加一个元素
    public void add(Item item){

        _items[_size++]=item;
    }

    //背包是否非空
    public boolean isEmpty(){return _size==0;}

    //背包中元素的数量
    public int size(){return _size;}

    //实现迭代器
    public Iterator<Item> iterator(){
        return new ListIterator();
    }       //Iterable接口方法的实现

    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>(40);

        int num=0;
        StdOut.println("input the number of:");
        if(!StdIn.isEmpty()){

            num=StdIn.readInt();
        }

        for(int i=-0;i<num;i++) {
            if (!StdIn.isEmpty())
                numbers.add(StdIn.readDouble());
        }

        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;

        double mean = sum/N;
        sum = 0.0;

        for (double x : numbers)
            sum += (x - mean)*(x - mean);

        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }



}
