package com.hy.tenalgorithm;

/**
 * @author hanyong
 * @date 2020/7/9 22:46
 */
public class Hannoitower {
    public static void main(String[] args) {
        hannoiTower(5, 'A', 'B', 'C');
    }

    public static void hannoiTower(int i, char a, char b, char c) {
        if (i == 1) {
            System.out.println("第1个盘从" + a + "=>" + c);
        } else if (i >= 2) {
            //将上面i-1的放到b上
            hannoiTower(i - 1, a, c, b);
            //再将a的最下面一个放到c上,最后一个直接挪到c,输出一句话即可
            System.out.println("第" + i + "个盘从" + a + "=>" + c);
            //最后将b上的放到c上
            hannoiTower(i - 1, b, a, c);
        }
    }
}
