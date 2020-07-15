package com.hy.tenalgorithm;

/**
 * @author hanyong
 * @date 2020/7/9 21:21
 */
public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] arr = {1, 8, 15, 19, 56, 79};
        System.out.print(binarySearchAlgorithm(arr, 79));

    }

    /**
     * @param arr    升序数组
     * @param target 要查找的目标
     * @return 返回查到的索引
     */
    public static int binarySearchAlgorithm(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
