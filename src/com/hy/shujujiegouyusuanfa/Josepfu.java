package com.hy.shujujiegouyusuanfa;

/**
 * @author hanyong
 * @date 2020/5/23 16:33
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();

        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList {

    private Boy first = null;

    //添加小孩节点，构成一个环形链表
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void show() {
        if (first == null) {
            System.out.println("没有任何小孩---");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            } else {
                curBoy = curBoy.getNext(); //curBoy后移
            }
        }
    }

    /**
     * 根据用户的输入，计算小孩的出圈顺序
     *
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 数几个数出圈
     * @param nums     总个数
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //数据校验
        if (first == null || startNo < 1 || countNum > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，帮助完成小孩出圈
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (first == helper) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d", first.getNo());

    }

}
    class Boy {
        private int no;
        private Boy next;

        public Boy(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }
    }