package com.hy.zrt;

import java.util.Scanner;

/**
 * @author hanyong
 * @date 2020/5/15 13:08
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNextLine()){
            String str=input.nextLine();
            System.out.println(reserve(str));
        }
//       System.out.println(reserve(input.nextLine()));
    }

    public  static String reserve(String str){
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }
}
