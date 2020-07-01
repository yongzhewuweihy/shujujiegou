package com.hy.shujujiegouyusuanfa.tree;

/**
 * @author hanyong
 * @date 2020/6/14 20:44
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder(0);
        arrBinaryTree.preOrder();

        System.out.println("后序遍历---");
        arrBinaryTree.postOrder();
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    //编写方法，前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        System.out.println(arr[index]);
        //左递归
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        //右递归
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    //编写方法，中序遍历
    public void mindOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        //左递归
        if (index * 2 + 1 < arr.length) {
            mindOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        //右递归
        if (index * 2 + 2 < arr.length) {
            mindOrder(index * 2 + 2);
        }
    }

    public void minOrder(){
        this.mindOrder(0);
    }
    //编写方法，后序遍历
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        //左递归
        if (index * 2 + 1 < arr.length) {
            postOrder(index * 2 + 1);
        }
        //右递归
        if (index * 2 + 2 < arr.length) {
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }

    public void postOrder(){
        this.postOrder(0);
    }
}