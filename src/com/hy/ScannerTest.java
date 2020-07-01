package com.hy;

import java.util.Scanner;

/**
 * @author hanyong
 * @date 2020/5/14 18:09
 */
public class ScannerTest {

    public static void main(String[] args) {
       Scanner in= new Scanner(System.in);
      String s1= in.next();//获得字符串 in.nextInt();获得输入的整数
       s1= s1.replace("[","").replace("]","");
      System.out.println(s1);
    }

}
