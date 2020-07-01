package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/12 23:52
 */
public class SingleL3 {
    private SingleL3(){};
    private  static SingleL3 instance;
    public static SingleL3 getInstance(){
        if(instance==null){
            synchronized (SingleL3.class){
                    instance=new SingleL3();
            }
        }
        return instance;
    }
}
