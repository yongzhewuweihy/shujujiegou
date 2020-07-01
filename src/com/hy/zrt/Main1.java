package com.hy.zrt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hanyong
 * @date 2020/5/15 12:40
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
          String str= input.next();
        //排序
        System.out.println(orderStr(str));
    }

    private static String orderStr(String str) {
        char[] chars= str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb=new StringBuilder();
        for(char ch:chars){
            sb.append(ch);
        }
        return sb.toString();
}
}
