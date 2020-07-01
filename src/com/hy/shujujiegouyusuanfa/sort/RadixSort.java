package com.hy.shujujiegouyusuanfa.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author hanyong
 * @date 2020/6/5 23:09
 */
public class RadixSort {

    public static void main(String[] args) {
//        int [] arr={53, 3, 542, 748, 14, 214};
        //第一轮结果{542, 53, 3, 14, 214, 748}
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

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    public static void radixSort(int [] arr){

        //确定需要轮数为最大数的位数
        //首先获取到最大值
        int max=arr[0];
        for(int i=1;i<arr.length;i++ ){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int length=(max+"").length();
        int [][] budcket=new int[10][arr.length];
        //10代表有0，1，2，3，4，5，6，7，8，9，总共10个桶
        //arr.length代表这个数组最多可以放多少个数，有可能arr所有的数同时放在了同一个桶里面
        int[] numCount=new int[10];
        //取出个位数,把数字分别放到对应的桶中,index代表第几个桶，numCount[index]代表这个同里数字的个数
        for(int m=0 , n=1; m<length;m++,n*=10){
            for(int i=0;i<arr.length;i++){
                int index=arr[i]/n%10;
                budcket[index][numCount[index]]=arr[i];
                numCount[index]++;
            }
            //取出数据
            int index1=0;
            for(int j=0;j<numCount.length;j++){
                //说明桶里面有数据
                if(numCount[j]!=0){
                    for(int k=0;k<numCount[j];k++){
                        arr[index1++]=budcket[j][k];
                    }
                }
                //清空数据，方便下次使用
                numCount[j]=0;
            }
//            System.out.println("第"+m+"轮排序"+ Arrays.toString(arr));
        }



        /*//第一轮排序
        //定义一个二维数组
        int [][] budcket=new int[10][arr.length];
        //10代表有0，1，2，3，4，5，6，7，8，9，总共10个桶
        //arr.length代表这个数组最多可以放多少个数，有可能arr所有的数同时放在了同一个桶里面
        int[] numCount=new int[10];
        //取出个位数,把数字分别放到对应的桶中,index代表第几个桶，numCount[index]代表这个同里数字的个数
        for(int i=0;i<arr.length;i++){
            int index=arr[i]%10;
            budcket[index][numCount[index]]=arr[i];
            numCount[index]++;
        }
        //取出数据
        int index1=0;
        for(int j=0;j<numCount.length;j++){
            //说明桶里面有数据
            if(numCount[j]!=0){
                for(int k=0;k<numCount[j];k++){
                   arr[index1++]=budcket[j][k];
                }
            }
            //清空数据，方便下次使用
            numCount[j]=0;
        }
        System.out.println("第一轮排序"+ Arrays.toString(arr));

        //第二轮排序
        for(int i=0;i<arr.length;i++){
            int index=arr[i]/10%10;
            budcket[index][numCount[index]]=arr[i];
            numCount[index]++;
        }
        //取出数据
        index1=0;
        for(int j=0;j<numCount.length;j++){
            //说明桶里面有数据
            if(numCount[j]!=0){
                for(int k=0;k<numCount[j];k++){
                    arr[index1++]=budcket[j][k];
                }
            }
            //清空数据，方便下次使用
            numCount[j]=0;
        }
        System.out.println("第二轮排序"+ Arrays.toString(arr));


        //第二轮排序
        for(int i=0;i<arr.length;i++){
            int index=arr[i]/100%10;
            budcket[index][numCount[index]]=arr[i];
            numCount[index]++;
        }
        //取出数据
        index1=0;
        for(int j=0;j<numCount.length;j++){
            //说明桶里面有数据
            if(numCount[j]!=0){
                for(int k=0;k<numCount[j];k++){
                    arr[index1++]=budcket[j][k];
                }
            }
            //清空数据，方便下次使用
            numCount[j]=0;
        }
        System.out.println("第三轮排序"+ Arrays.toString(arr));*/
    }
}
