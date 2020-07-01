package com.hy.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanyong
 * @date 2020/5/20 20:47
 */
public class ArrayListDeo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("5");
        list.remove(4);
    }
}
