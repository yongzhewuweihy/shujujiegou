package com.hy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @author hanyong
 * @date 2020/5/8 0:37
 */
public class Multi {

    public static void main(String[] args) {
        Thread thread1=new Thread(new ThedDemo(),"新城1");
        StringBuffer sb=new StringBuffer(0);
        thread1.start();
        Collection cq=new ArrayList();

    }

    private static class ThedDemo implements Runnable{

        @Override
        public void run() {
            System.out.println("多线程tdrun方法执行了");
        }
    }

}
