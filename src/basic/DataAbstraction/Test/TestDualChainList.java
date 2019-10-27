package basic.DataAbstraction.Test;

import basic.DataAbstraction.ImplementByLinkedList.DualChainList;

public class TestDualChainList {

    public static void main(String[] args){


        DualChainList<String> strList=new DualChainList<>();

        String[] strArray=new String[]{"this","is","a","dual","link","list"};

        System.out.println("the strList is Empty: "+strList.isEmpty());

        //insertFromHead
        for(String s:strArray){
            strList.insertFromHead(s);
        }

        System.out.println("the strList is Empty: "+strList.isEmpty());


        System.out.println("the size of the string linklist is "+strList.getSize());

        for(String s:strList){
            System.out.print(s+" ");
        }

        System.out.println();

        //deleteFromHead()
        System.out.println(strList.deleteFromHead());

        System.out.println(strList.deleteFromHead());

        System.out.println("the size of the string linklist is "+strList.getSize());

        for(String s:strList){
            System.out.print(s+" ");
        }
        System.out.println();










        strArray=new String[]{"construct","by","java"};

        //insertFromTail
        for(String s:strArray){
            strList.insertFromTail(s);
        }

        System.out.println("the strList is Empty: "+strList.isEmpty());


        System.out.println("the size of the string linklist is "+strList.getSize());

        for(String s:strList){
            System.out.print(s+" ");
        }

        System.out.println();

        //deleteFromTail()
        System.out.println(strList.deleteFromTail());

        System.out.println(strList.deleteFromTail());

        System.out.println("the size of the string linklist is "+strList.getSize());

        for(String s:strList){
            System.out.print(s+" ");
        }
        System.out.println();

        //strList.insertNodeAtFrontOf()
        strList.insertNodeAtFrontOf(strList.getSize()/2,"insertword1");

        strList.insertNodeAtNextOf(strList.getSize()/2,"insertword2");

        System.out.println("the size of the string linklist is "+strList.getSize());

        for(String s:strList){
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("delete #"+strList.getSize()/2+"Node: "
                +strList.deleteNode(strList.getSize()/2));

        System.out.println("the size of the string linklist is "+strList.getSize());

        for(String s:strList){
            System.out.print(s+" ");
        }
        System.out.println();

    }
}
