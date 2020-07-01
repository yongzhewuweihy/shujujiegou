package com.hy.shujujiegouyusuanfa.tree;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author hanyong
 * @date 2020/6/16 20:50
 */
public class HeapSort {
    //第一个非叶子几点的索引是arr.length/2-1;
    public static void main(String[] args) {
        //int[] arr = {4, 6, 8, 5, 9,-9,99,85,-999};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        heapSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        //System.out.println(Arrays.toString(arr));
    }

    //编写一个堆排序算法
    public static void heapSort(int[] arr) {
        int temp=0;
        //1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或者小顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        //2.将堆顶元素与末尾元素进行交换，将最大元素沉到数组末端
        //3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
    }

    //将一个数组(二叉树)，调整成一个大顶堆

    /**
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续进行调整，length是逐渐在减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果非叶子节点的右子节点大则k指向右子节点的索引，负责依然是左子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //小于则让arr[i]变成下面较大的一个
            if (arr[i] < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                //否则不进行任何操作，break的原因是从左至右，从下到上，确保下面没有比arr[i]大的值了
                break;
            }
            //循环过后i指向的是下面的k，也就是较大值的索引。值需要进行交换，把之前的值赋值过来
            arr[i] = temp;
        }
    }
}
