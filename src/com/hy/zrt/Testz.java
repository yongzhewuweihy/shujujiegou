package com.hy.zrt;

import java.util.Scanner;

/**
 * @author hanyong
 * @date 2020/5/14 23:41
 */
public class Testz {
    //static不能修饰局部变量，会编译失败
    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String str=input.nextLine();
            System.out.println(CalUpNum(str));
        }
    }

    public static int CalUpNum(String str){

        char[] chas=str.toCharArray();
        int count=0;
        for(int i=0;i<chas.length;i++){
             if(chas[i]>='A'&&chas[i]<='Z'){
                 count++;
             }
        }
        return count;
    }*/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nu1 = input.nextInt();
        int nu2 = input.nextInt();
       System.out.println(reserve(reserve(nu1)+reserve(nu2)) );
    }

    public static int reserve(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        return (Integer.parseInt(sb.reverse().toString()));
    }

}
