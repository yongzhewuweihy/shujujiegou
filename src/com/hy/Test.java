package com.hy;

import java.util.*;

/**
 * @author hanyong
 * @date 2020/5/19 19:22
 */
public class Test {
// my name is hy

    public static void main(String[] args) {

        List<String> list=reOrder("my name is hy");
        for (String s:list){
            System.out.print(s+" ");
        }
    }

    public static List<String> reOrder(String str) {
        String[] strs = str.split(" ");
        List<String> list = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
           list.add(strs[i]);
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        //Collections.sort(list, Comparator.comparingInt(String::length));
        return  list;
    }
}
