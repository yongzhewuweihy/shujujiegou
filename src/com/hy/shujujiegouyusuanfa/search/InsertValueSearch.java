package com.hy.shujujiegouyusuanfa.search;

/**
 * @author hanyong
 * @date 2020/6/6 18:56
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int [] arr=new int [100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
        int index=insertValueSearch(arr,0,arr.length-1,5);
        System.out.println(index);
    }

    public static int insertValueSearch(int [] arr,int left,int right,int findValue){

        if(left>right||findValue<arr[0]||findValue>arr[arr.length-1]){
            return -1;
        }
        int mid=left+((right-left)*(findValue-arr[left])/(arr[right]-arr[left]));
        int midValue=arr[mid];
        if(findValue>midValue){
            insertValueSearch(arr,mid+1,right,findValue);
        }else if(findValue<midValue){
            insertValueSearch(arr,left,mid-1,findValue);
        }else{
            return mid;
        }




        return 0;
    }
}
