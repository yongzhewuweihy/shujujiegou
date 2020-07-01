package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/12 23:43
 */
public class SingleL2 {
    private SingleL2(){};
    private static SingleL2 instance;
    public static synchronized SingleL2 getInstance(){
        if(instance==null){
            instance=new SingleL2();
        }
        return instance;
    }
}
