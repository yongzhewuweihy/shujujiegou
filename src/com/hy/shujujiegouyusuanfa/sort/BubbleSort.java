package com.hy.shujujiegouyusuanfa.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 冒泡排序
 * @author hanyong
 * @date 2020/5/30 17:28
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int [] arr={3,9,-1,10,-2};
        int [] arr=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*800000);
        }
       long staTi= System.currentTimeMillis();
        bubbleSort(arr);
        long endTi= System.currentTimeMillis();
        System.out.println("耗时"+(endTi-staTi)/1000+"秒");
        System.out.println(Arrays.toString(arr));
        /*boolean flag=false;
        int temp=0;
        for(int j=0;j<arr.length-1;j++){
            for(int i=0;i<arr.length-1-j;i++){
                temp=arr[i];
                if(arr[i]>arr[i+1]){
                    flag=true;
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            System.out.printf("第%d趟排序后的数组",j+1);
            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else {
                //重置成false在进行判断
                flag=false;
            }
        }*/


        /*//第一趟排序
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            temp=arr[i];
            if(arr[i]>arr[i+1]){
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));*/
        /*//第二趟排序
        for(int i=0;i<arr.length-1-1;i++){
            temp=arr[i];
            if(arr[i]>arr[i+1]){
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        //第三趟排序
        for(int i=0;i<arr.length-1-2;i++){
            temp=arr[i];
            if(arr[i]>arr[i+1]){
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        //第四趟排序
        for(int i=0;i<arr.length-1-3;i++){
            temp=arr[i];
            if(arr[i]>arr[i+1]){
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));*/
    }
    public static void bubbleSort(int [] arr){
        boolean flag=false;
        int temp=0;
        for(int j=0;j<arr.length-1;j++){
            for(int i=0;i<arr.length-1-j;i++){
                temp=arr[i];
                if(arr[i]>arr[i+1]){
                    flag=true;
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            if(!flag){
                break;
            }else {
                //重置成false在进行判断
                flag=false;
            }
        }
    }
}
