package com.hy.shujujiegouyusuanfa.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找法要求数组有序
 * @author hanyong
 * @date 2020/6/6 13:38
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89,89,89, 1000, 1234};
        List<Integer> index = binarySearch2(arr, 0, arr.length-1, 98);
        System.out.println("索引值是" + index);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue=arr[mid];
        if (findVal < midValue) {
            //向右递归
            return binarySearch(arr, left, mid-1, findVal);
        } else if (findVal > midValue) {
            //向左递归
            return binarySearch(arr, mid+1, right, findVal);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midValue=arr[mid];
        if (findVal < midValue) {
            //向左递归
            return binarySearch2(arr, left, mid-1, findVal);
        } else if (findVal > midValue) {
            //向右递归
            return binarySearch2(arr, mid+1, right, findVal);
        } else {
            List<Integer> integerList=new ArrayList<>();
            //向左查找
            int index=mid-1;
            while(true){
                if(index<0||arr[index]!=findVal){
                    break;
                }
                integerList.add(index);
                index-=1;
            }
            integerList.add(mid);
            //向右查找
             index=mid+1;
            while(true){
                if(index>arr.length-1||arr[index]!=findVal){
                    break;
                }
                integerList.add(index);
                index+=1;
            }
            return integerList;
        }
    }
}
