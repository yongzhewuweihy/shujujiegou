package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/12 23:24
 */
public class SingleE2 {

    private static SingleE2 instance;
    private SingleE2(){}
    static {
        instance=new SingleE2();
    }
    public static SingleE2 getInstance(){
        return  instance;
    }
}
