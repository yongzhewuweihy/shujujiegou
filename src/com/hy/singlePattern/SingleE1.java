package com.hy.singlePattern;

/**
 * @author hanyong
 * @date 2020/5/12 23:07
 */
public class SingleE1 {

    private SingleE1(){

    }

    private static SingleE1 instance=new SingleE1();

    public static SingleE1 getInstance(){
        return  instance;
    }
}

class Test implements Runnable{
    @Override
    public void run() {
        SingleE1.getInstance();
    }

    @org.junit.Test
    public void test1(){
        Thread thread1=new Thread(new Test());
        Thread thread2=new Thread(new Test());
        thread1.start();
        thread2.start();
    }
}

