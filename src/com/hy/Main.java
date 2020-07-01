package com.hy;

/**
 * @author hanyong
 * @date 2020/5/14 1:26
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> integerList=new ArrayList<>();
            String value=in.next();
            String [] strings= value.replace("[","").replace("]","").split(",");
            for (int i=0;i<strings.length;i++){
                integerList.add(Integer.parseInt(strings[i])) ;
            }
       Integer[] integers=integerList.toArray(new Integer[0]) ;
        System.out.println(getMaxArea(integers));
    }

    //得到最大面积
    public static int getMaxArea(Integer [] height){
        int len = height.length;
        if (len < 2) {
            // 0 或者 1 的时候，不能形成区间，所以不能形成容器
            return 0;
        }
        int l = 0;
        int r = len - 1;
        int res = 0;
        while (l < r) {
            // 这里其实就是木桶原理，取决于最短的那根木板
            // [1,2,3] 3 和 1 之间的长度就是 (3-1=)2
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                // height[l] >= height[r]
                r--;
            }
        }
        return res;
    }
}
