package com.penghui;

import java.io.*;
import java.util.Scanner;

/**
 *  测试键盘输入
 */
public class _01demo {

    public static void main(String[] args) throws IOException {

//        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));

        Scanner input = new Scanner(System.in);

        String s;
        System.out.print("input a sentence: ");
        while(!(s = input.next()).equals("exit")){
            System.out.println("-----"+s);
            System.out.print("input a sentence: ");
        }


    }


}
