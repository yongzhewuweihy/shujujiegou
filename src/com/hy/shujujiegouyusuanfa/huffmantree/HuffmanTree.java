package com.hy.shujujiegouyusuanfa.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hanyong
 * @date 2020/6/17 21:27
 */
public class HuffmanTree {
    public static void main(String[] args) {
        //arr = {4,6,8,5,9}
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root=createHuffmanTree(arr);
        preOrder(root);
    }


    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空，无法进行遍历");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        //1.首先将arr构建成节点
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        //返回父节点
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大的进行排列
        return this.value - o.value;
    }
}