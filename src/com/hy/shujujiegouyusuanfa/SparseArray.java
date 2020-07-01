package com.hy.shujujiegouyusuanfa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hanyong
 * @date 2020/5/14 19:08
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //稀疏数组转为二维数组
        int multiArray[][] = new int[11][11];
        multiArray[1][2] = 1;
        multiArray[2][3] = 2;
        //遍历二维数组，首先row为行
        for (int[] row : multiArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("------------");

        //二维数组转换为稀疏数组,sum为二维数组的行
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (multiArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        int spareArray[][] = new int[sum + 1][3];
        spareArray[0][0] = 11;
        spareArray[0][1] = 11;
        spareArray[0][2] = sum;


        int count = 0;
        //遍历二维数组，存值到疏松数组
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (multiArray[i][j] != 0) {
                    count++;
                    spareArray[count][0] = i;//二维数组里面的行
                    spareArray[count][1] = j;//二维数组里面的列
                    spareArray[count][2] = multiArray[i][j];//二维数组里不等于0的值
                }
            }
        }

        //打印疏松数组spareArray[sum+1][3]
        for (int i = 0; i < spareArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spareArray[i][0], spareArray[i][1], spareArray[i][2]);
        }

        //保存稀疏数组到磁盘
       /* FileOutputStream fos=new FileOutputStream(new File("d:/study/data/map.data"));
        OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
        for (int i = 0; i < spareArray.length; i++) {
            osw.append(spareArray[i][0]+"   "+spareArray[i][1]+"    "+spareArray[i][2]+"\n");

        }
        System.out.println("写入中");
        osw.flush();
        fos.close();*/

        InputStream inputStream = new FileInputStream(new File("d:/study/data/map.data"));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line;
        //创建疏松数组
        List<Integer> integers=new ArrayList<>();
        while ((line=br.readLine())!=null){
            String[] strings=line.split("\\s+");
            for(String s:strings){
                integers.add(Integer.parseInt(s));
            }
        }
        int spars1[][] =new int[integers.size()/3][3];

        int i=0;
        for(int s:integers){
            spars1[(i - (i % 3)) / 3][i % 3]=s;
        i++;
    }


    //遍历读取的疏松数组
        System.out.println("遍历读取的疏松数组------------------------------------------------------------------");
        for (int[] row : spars1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }



        //疏松数组转化为二维数组，并打印二维数组
        int erweiArray[][] = new int[spareArray[0][0]][spareArray[0][1]];
        int count1 = spareArray[0][2];
        for (int l = 1; l < count1 + 1; l++) {
            //行spareArray[i][0] 列spareArray[i][1] 值spareArray[i][2]
            erweiArray[spareArray[l][0]][spareArray[l][1]] = spareArray[l][2];
        }

        for (int[] row : erweiArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }


}
