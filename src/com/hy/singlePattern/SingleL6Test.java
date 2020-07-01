package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/13 0:22
 */
public class SingleL6Test {

    public static void main(String[] args) {
        SingleL6 in1=SingleL6.INSTANCE;
        SingleL6 in2=SingleL6.INSTANCE;
        System.out.println(in1==in2);
        in1.test();
    }
}
enum SingleL6{
    INSTANCE;
    public void test(){
        System.out.println("whh");
    }
}