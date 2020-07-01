package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/12 23:32
 */
public class SingleL1 {
    private SingleL1(){};
    private static SingleL1 instance;
    public static SingleL1 getInstance(){
        if(null==instance){
            instance=new SingleL1();
        }
        return instance;
    }
}
