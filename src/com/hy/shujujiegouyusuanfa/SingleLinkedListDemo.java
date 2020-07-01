package com.hy.shujujiegouyusuanfa;

import java.util.Stack;

/**
 * @author hanyong
 * @date 2020/5/19 15:07
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);


        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(hero1);
        singleLinkedList2.addByOrder(hero3);
        singleLinkedList2.addByOrder(hero5);
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.addByOrder(hero2);
        singleLinkedList3.addByOrder(hero4);
        singleLinkedList3.addByOrder(hero6);


        System.out.println("合并后=---================================------------------------------");
        combaTwoSLL(singleLinkedList2,singleLinkedList3).list();
        System.out.println("合并分割=---================================------------------------------");

        //显示一把
        singleLinkedList.list();

        System.out.println("=---------------------------------");

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.addByOrder(hero2);
        singleLinkedList1.addByOrder(hero1);
        System.out.println("按顺序插入-------------------------------");
        singleLinkedList1.list();
        /*reserve(singleLinkedList.getHead());
        singleLinkedList.list();*/

        revessePrint(singleLinkedList.getHead());
        /*System.out.println("=---------------------------------");
        //测试修改后的
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟--");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        System.out.println("=---------------------------------");
        //测试删除后的
        singleLinkedList.del(1);
        singleLinkedList.list();
        System.out.println(getLength(singleLinkedList.getHead()));
        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 1));*/
    }

    //获取链表有效节点个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //获取链表倒数第i个对应的节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表是否为空
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        //判断index的合法性
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode heroNode = head.next;
        for (int i = 0; i < size - index; i++) {
            heroNode = heroNode.next;
        }
        return heroNode;
    }

    //单链表的反转
    public static void reserve(HeroNode head) {
        //如果为空，或者只有一个这则不存在反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;//当前节点的下一个节点
        HeroNode newHeadHeroNode = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = newHeadHeroNode.next;//将cur的下一个节点指向新的链表的最前端
            newHeadHeroNode.next = cur;//将cur连接到最新的链表上
            cur = next;//将cur后移
        }
        head.next = newHeadHeroNode.next;
    }

    //链表逆序打印，使用到stack
    public static void revessePrint(HeroNode head) {
        if (head.next == null) {
            //空链表不打印
            return;
        }
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode heroNode = head.next;
        while (heroNode != null) {
            heroNodes.push(heroNode);
            heroNode = heroNode.next;
        }
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }

    //合并两个有序的单链表，合并之后的链表依然有序
    public static SingleLinkedList combaTwoSLL(SingleLinkedList  list1, SingleLinkedList list2) {
        HeroNode head1=list1.getHead();
        HeroNode head2=list2.getHead();
        if (head1.next == null && head2.next == null) {
            return null;
        }
        if (head1.next == null) {
            return list2;
        }
        if (head2.next == null) {
            return list1;
        }
        SingleLinkedList singleLinkedList=new SingleLinkedList();

        HeroNode newHeadNode=singleLinkedList.getHead();
        HeroNode temp1=head1.next;
        HeroNode temp2=head2.next;
        HeroNode temp=newHeadNode;
        /*if(temp1.no<=temp2.no){
            temp.next=temp1;
            temp1=temp1.next;
        }else if(temp1.no>temp2.no){
            temp.next=temp2;
            temp2=temp2.next;
        }
        temp=temp.next;*/
        while(temp1!=null&&temp2!=null){
            if(temp1.no<=temp2.no){
                temp.next=temp1;
                temp1=temp1.next;
            }else if(temp1.no>temp2.no){
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1==null){
            temp.next=temp2;
        }
        if(temp2==null){
            temp.next=temp1;
        }
        return singleLinkedList;
    }
}


class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean falg = false;//添加的编号是否存在
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最尾端
                break;
            }
            if (temp.next.no > heroNode.no) {
                //说明已经找到
                break;
            } else if (temp.next.no == heroNode.no) {
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if (falg) {
            System.out.printf("该节点 %d 已经存在", heroNode.no);
        } else {
            //不存在则进行添加
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        //1.根据newHeroNode的no进行修改
        //判断事否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点，根据no进行编写
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }


}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}