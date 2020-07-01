package com.hy.shujujiegouyusuanfa.sort;

import java.util.Arrays;

/**
 * @author hanyong
 * @date 2020/6/2 20:57
 */
public class ShellSort {
    public static void main(String[] args) {
        //int [] arr={8,9,1,7,2,3,5,4,6,0};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        long staTi = System.currentTimeMillis();
        //shellSort(arr);
        shellSort2(arr);
        long endTi = System.currentTimeMillis();
        System.out.println("耗时" + (endTi - staTi));
    }

    //比较法
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    temp = arr[j + gap];
                    if (arr[j] > arr[j + gap]) {
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
//            System.out.println("第"+(++count)+"次排序"+ Arrays.toString(arr));
        }
    }

    //位移法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for(int i=gap;i<arr.length;i++){
                //将要插入的存起来
                int j=i;
                int temp=arr[j];
                //满足条件说明当前要插入的值小于他这一组左侧紧邻的值
                if(arr[j]<arr[j-gap]){
                    //j-gap>0确保可以继续往左侧遍历，
                    //temp<arr[j-gap] 满足条件才需要继续寻找
                    while(j-gap>=0 && temp<arr[j-gap]){
                            arr[j]=arr[j-gap];
                            j-=gap;
                    }
                    //当退出while后，就给temp找到位置
                    arr[j]=temp;
                }

            }
        }
//        System.out.println(Arrays.toString(arr));
    }
}
