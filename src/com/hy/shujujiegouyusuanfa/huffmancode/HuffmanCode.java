package com.hy.shujujiegouyusuanfa.huffmancode;

import java.util.*;

/**
 * @author hanyong
 * @date 2020/6/18 22:03
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        System.out.println(bytes.length);

        byte[] huffmanCodeBytes = zip(bytes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
        /*List<Node> nodes = getNodes(bytes);
        Node rootNode = createHuffmanTree(nodes);

        preOrder(rootNode);
        System.out.println("处理后---------");
//        getCodes(rootNode, "", stringBuilder);
        Map<Byte, String> hump = getCodes(rootNode);
        System.out.println(hump);


        byte[] huffmanCodeBytes = zip(bytes, hump);
        System.out.println("huffmanCodeBytes" + Arrays.toString(huffmanCodeBytes));*/
    }

    /**
     * 神封装
     *
     * @param bytes
     * @return
     */
    private static byte[] zip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node rootNode = createHuffmanTree(nodes);
        Map<Byte, String> huffmapCodes = getCodes(rootNode);
        byte[] huffmanCodeBytes = zip(bytes, huffmapCodes);
        return huffmanCodeBytes;
    }

//编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]

    /**
     * @param bytes        这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 举例： String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返回的是 字符串 "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes  ，即 8位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] =  10101000(补码) => byte  [推导  10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //System.out.println("测试 stringBuilder~~~=" + stringBuilder.toString());

        //将 "1010100010111111110..." 转成 byte[]

        //统计返回  byte[] huffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每8位对应一个byte,所以步长 +8
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * @param bytes 接收字节数组
     * @return 返回的就是 List 形式   [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......],
     */
    private static List<Node> getNodes(byte[] bytes) {

        //1创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();

        //遍历 bytes , 统计 每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { // Map还没有这个字符数据,第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;

    }

    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    //
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;

    }

    /**
     * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入huffmanCodes集合中
     *
     * @param node
     * @param code
     * @param stringBuilder
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {//node==null则不处理
            //判断当前节点是不是叶子节点
            if (node.data == null) {//非叶子节点
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {//说明是叶子节点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空，不能遍历");
        }
    }

}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}