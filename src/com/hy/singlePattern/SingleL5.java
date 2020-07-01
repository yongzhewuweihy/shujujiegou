package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/13 0:07
 */
public class SingleL5 {
    private SingleL5(){}
    private static class SingleL5Instance{
        private final static  SingleL5 INSTANCE=new SingleL5();
    }
    public static SingleL5 getInstance(){
        return SingleL5Instance.INSTANCE;
    }
}
