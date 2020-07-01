package com.hy.shujujiegouyusuanfa.sort;

import java.util.Arrays;

/**
 * @author hanyong
 * @date 2020/6/1 22:00
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long st = System.currentTimeMillis();
        insertSort(arr);
        long et = System.currentTimeMillis();
        System.out.println("耗时" + ((et - st) / 1000) + "秒");
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        int sortValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            sortValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && sortValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = sortValue;
            }

           /* System.out.println("第"+i+"轮排序");
            System.out.println(Arrays.toString(arr));*/
        }

        /*//第一个默认是有序，从第二个开始跟第一开始比。从第i个开始跟第i-1个比
        //第一轮排序
        int sortValue=arr[1];
        int insertIndex=1-1;
        while(insertIndex>=0 && sortValue<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=sortValue;
        System.out.println("第一轮排序");
        System.out.println(Arrays.toString(arr));

        //第二轮排序
         sortValue=arr[2];
         insertIndex=2-1;
        while(insertIndex>=0 && sortValue<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=sortValue;
        System.out.println("第二轮排序");
        System.out.println(Arrays.toString(arr));

        //第三轮排序

        sortValue=arr[3];
        insertIndex=3-1;
        while(insertIndex>=0 && sortValue<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=sortValue;
        System.out.println("第三轮排序");
        System.out.println(Arrays.toString(arr));*/
    }
}
