package com.hy.zrt;

import java.util.Scanner;

/**
 * @author hanyong
 * @date 2020/5/15 13:31
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int sum=0;
        int b;
        int count=0;
        while(in.hasNext()){
            count++;
            if((b=in.nextInt())<a){
                sum+=b;
            }
            if(count ==5){
                break;
            }
        }
        System.out.println(sum);
        in.close();
    }
}
