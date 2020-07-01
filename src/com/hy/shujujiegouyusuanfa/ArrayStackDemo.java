package com.hy.shujujiegouyusuanfa;

/**
 * @author hanyong
 * @date 2020/5/25 14:29
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

class ArrayStack{
    private int maxSize;
    private int top=-1;
    private int [] stack;

    public  ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top==maxSize;
    }

    //判断栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //遍历栈
    public void show(){
        if(isEmpty()){
            throw  new RuntimeException("栈空没有数据");
        }
        for(int i=top;i>-1;i--){
            System.out.printf("stack[]");
        }
    }

    //添加元素
    public void push(int num){

    }

    //弹出元素
    public void pop(){

    }
}