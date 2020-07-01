package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/13 0:01
 */
public class SingleL4 {
    private SingleL4(){};
    private  volatile static SingleL4 instance;
    public static SingleL4 getInstance(){
        if(instance==null){
            synchronized (SingleL4.class){
                if(instance==null){
                    instance=new SingleL4();
                }
            }
        }
        return instance;
    }
}
