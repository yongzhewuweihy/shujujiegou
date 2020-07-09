package com.hy.shujujiegouyusuanfa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hanyong
 * @date 2020/7/6 22:41
 */
public class Graph {
    private List<String> vertexList;
    private int numOfEdges;
    private int[][] net;
    private boolean[] isvisted;

    public static void main(String[] args) {
        String[] strs = {"A", "B", "C", "D", "E"};
        int n = 5;
        Graph graph = new Graph(n);
        for (String s : strs) {
            graph.addVert(s);
        }
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);

//        graph.show();

        System.out.print("深度遍历");
        //graph.dfs();

        System.out.print("广度遍历");
        graph.bfs();

    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        net = new int[n][n];
        numOfEdges = 0;
        isvisted = new boolean[n];
    }


    public void dfs() {
        isvisted = new boolean[vertexList.size()];
        for (int i = 0; i < getNumofVertex(); i++) {
            if (!isvisted[i]) {
                dfs(isvisted, i);
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param isvisted
     * @param i
     */
    private void dfs(boolean[] isvisted, int i) {
        System.out.print(getByIndex(i) + "->");
        String ver = getByIndex(i);
        isvisted[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isvisted[w]) {
                dfs(isvisted, w);
            } else {
                //当前节点的邻接点存在但是已经被访问,查找当前节点的邻接点的邻接点
                w = getNexNeighborByPreviousNei(i, w);

            }
        }
    }


    public void bfs() {
        isvisted = new boolean[vertexList.size()];
        for (int i = 0; i < getNumofVertex(); i++) {
            if (!isvisted[i]) {
                bfs(isvisted, i);
            }

        }
    }

    /**
     * 广度优先遍历
     *
     * @param isvisted
     * @param i
     */
    private void bfs(boolean[] isvisted, int i) {
        int u;//队列头节点对应的下标
        System.out.print(getByIndex(i) + "=>");
        isvisted[i] = true;
        //队列记录节点访问顺序
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i);//队列末尾加入
        while (!queue.isEmpty()) {
            //分析这个节点后面的邻接节点
            u = queue.removeFirst();
            int w = getFirstNeighbor(u);
            //w!=-1说明这个节点的邻接节点存在，存在并且没有被访问则输出，并且标记为已输出
            while (w != -1) {
                if (!isvisted[w]) {
                    System.out.print(getByIndex(w) + "=>");
                    isvisted[w] = true;
                    queue.addLast(w);
                }
                w = getNexNeighborByPreviousNei(u, w);
            }
        }


    }

    /**
     * 得到当前节点的第一个邻节点的索引下标，不存在就返回-1
     *
     * @param index 当前节点的索引下标
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (net[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 根据上一个邻接点的索引，找下一个临结点的索引下标
     *
     * @param i     上一个邻接点的索引下标
     * @param index 当前节点的索引下标
     * @return
     */
    public int getNexNeighborByPreviousNei(int index, int i) {
        for (int j = i + 1; j < vertexList.size(); j++) {
            if (net[index][j] > 0) {
                return j;
            }
        }
        return -1;
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
    public int getNumofVertex() {
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
