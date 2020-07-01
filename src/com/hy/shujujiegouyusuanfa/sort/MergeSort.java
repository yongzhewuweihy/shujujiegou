package com.hy.shujujiegouyusuanfa.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author hanyong
 * @date 2020/6/4 22:43
 */
public class MergeSort {
    public static void main(String[] args) {
        //int [] arr={8,4,5,7,1,3,6,2};
        int[] arr = new int[8000000];
        int [] temp=new int[arr.length];
        for (int i = 0; i < 8000000; i++) {
            // 生成一个[0, 8000000) 数
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        mergeSort(arr,0,arr.length-1,temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        //System.out.println(Arrays.toString(arr));
    }

    //分+合方法
    public static void mergeSort(int [] arr,int left,int right,int [] temp){
        if(left<right){
            //中间索引
            int mid= (left+right)/2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     *合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int [] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        //1.先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //2.把有剩余数据的一边的数据以此全部填充到temp
        //假如左边没完
        while (i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        //假如右边没完
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        //3.将temp数组的元素拷贝到arr
        //并不是每次都拷贝所有
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
