package com.hy.zrt;

/**
 * @author hanyong
 * @date 2020/5/15 12:15
 */
public class Person {
    private String name = "Person";
    int age=0;
}
 class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        //不能访问父类的private成员变量
//    System.out.println(p.name);
    }
}
