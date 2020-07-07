package com.hy.shujujiegouyusuanfa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hanyong
 * @date 2020/7/6 22:41
 */
public class Graph {
    private List<String> vertexList;
    private int numOfEdges;
    private int[][] net;

    public static void main(String[] args) {
        String[] strs = {"A", "B", "C", "D", "E"};
        int n = 5;
        Graph graph = new Graph(n);

    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        net = new int[n][n];
        numOfEdges = 0;
    }

    /**
     * 添加节点
     *
     * @param vert
     */
    public void addVert(String vert) {
        vertexList.add(vert);
    }

    /**
     * 获取图的节点的个数
     *
     * @return
     */
    public int getLength() {
        return vertexList.size();
    }

    /**
     * 获取边的个数
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 添加边
     *
     * @param i      顶点的索引
     * @param j      顶点的索引
     * @param weight 权值
     */
    public void addEdge(int i, int j, int weight) {
        net[i][j] = weight;
        net[j][i] = weight;
        numOfEdges++;
    }

    /**
     * 打印邻接矩阵
     */
    public void show() {
        for (int[] temp : net) {
            System.err.println(Arrays.toString(temp));
        }
    }

    /**
     * 根据索引获取对应的顶点
     *
     * @param index
     * @return
     */
    public String getByIndex(int index) {
        return vertexList.get(index);
    }
}
