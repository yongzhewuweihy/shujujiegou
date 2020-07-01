package com.hy.shujujiegouyusuanfa;

/**
 * @author hanyong
 * @date 2020/5/28 23:56
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    static int count = 0;
    //定义数组array，保存皇后放的位置的结果，比如arr={0,4,7,5,2,6,1,3}
    //arr[i]=value,表示第i+1行的第value+1列有皇后
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("总共有%d种解法",count);
    }

    //放置第n个皇后
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            //先把当前皇后n放在改行的第一列
            array[n] = i;
            //判断当前皇后放置到第i列是否冲突
            if (judge(n)) {
                //不冲突的话,接着放n+1个皇后
                check(n + 1);
            }
            //冲突的话，i会自增，列会变化
        }
    }

    //查看当放第n个皇后，检测该皇后是否和以前已经摆的皇后冲突

    /**
     * array[i]==array[n]表示在同一列，Math.abs(n-i)==Math.abs(array[n]-array[i])表示在同一斜线
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，输出皇后的位置
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
