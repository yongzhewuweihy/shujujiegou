package com.hy.shujujiegouyusuanfa.sort;

import java.util.Arrays;

/**
 * @author hanyong
 * @date 2020/5/30 23:25
 */
public class SelectSort {

    public static void main(String[] args) {
       /* int[] arr = {101, 34, 119, 1};
        selectSort(arr);*/
        int [] arr=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        long staTi= System.currentTimeMillis();
        selectSort(arr);
        long endTi= System.currentTimeMillis();
        System.out.println("耗时"+(endTi-staTi));
//        System.out.println(Arrays.toString(arr));
    }


    //选择排序
    public static void selectSort(int[] arr) {
        //101, 34, 119, 1
        //第1次排序
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                //假定的值并非是最小值
                if (min > arr[j]) {
                    //重置minIndex，min
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第"+(i+1)+"次排序");
//            System.out.println(Arrays.toString(arr));
        }



        /*//第1次排序
        int minIndex = 0;
        int min = arr[0];
        for (int j = 0 + 1; j < arr.length; j++) {
            //假定的值并非是最小值
            if (min > arr[j]) {
                //重置minIndex，min
                min = arr[j];
                minIndex = j;
            }
        }
        if(minIndex!=0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第一次排序");
        System.out.println(Arrays.toString(arr));

        //第2次排序
         minIndex = 1;
         min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            //假定的值并非是最小值
            if (min > arr[j]) {
                //重置minIndex，min
                min = arr[j];
                minIndex = j;
            }
        }
        if(minIndex!=1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二次排序");
        System.out.println(Arrays.toString(arr));
        //第3次排序
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            //假定的值并非是最小值
            if (min > arr[j]) {
                //重置minIndex，min
                min = arr[j];
                minIndex = j;
            }
        }
        if(minIndex!=2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第三次排序");
        System.out.println(Arrays.toString(arr));*/
    }

}
