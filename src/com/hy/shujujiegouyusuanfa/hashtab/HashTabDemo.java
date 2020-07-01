package com.hy.shujujiegouyusuanfa.hashtab;

import java.util.Scanner;

/**
 * @author hanyong
 * @date 2020/6/9 23:23
 */
public class HashTabDemo {
    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 查找雇员");
            System.out.println("exit: 退出系统");
            String key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入名字");
                    String name = scanner.next();
                    Employ employ = new Employ(id, name);
                    hashTab.add(employ);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("请输入要删除的id");
                    id = scanner.nextInt();
                    hashTab.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }


        }
    }
}

class HashTab {
    public int size;
    public EmployList[] employListsArray;

    //构造器
    public HashTab(int size) {
        this.size = size;
        employListsArray = new EmployList[size];
        for (int i = 0; i < size; i++) {
            employListsArray[i] = new EmployList();
        }
    }

    //添加雇员
    public void add(Employ employ) {
        int employListsArrayIndex = hashFun(employ.id);
        employListsArray[employListsArrayIndex].add(employ);
    }

    //遍历所有链表
    public void list() {
        for (int i = 0; i < size; i++) {
            employListsArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int employListsArrayIndex = hashFun(id);
        Employ employ = employListsArray[employListsArrayIndex].findById(id);
        if (employ == null) {
            System.out.println("在哈希表中，没有找到该雇员~");
        } else {
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (employListsArrayIndex + 1), id);
        }
    }

    public void delete(int id){
        int employListsArrayIndex = hashFun(id);
        employListsArray[employListsArrayIndex].deleteById(id);
    }

    //编写散列函数，简单取模法
    public int hashFun(int id) {
        return id % size;
    }
}

/**
 * 雇员链表
 */
class EmployList {
    private Employ head;

    //添加员工
    public void add(Employ emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Employ cruEmp = head;
        while (true) {
            if (cruEmp.next == null) {
                break;
            }
            cruEmp = cruEmp.next;
        }
        cruEmp.next = emp;
    }

    //遍历链表员工
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表没有数据");
            return;
        }
        System.out.print("第" + (no + 1) + "条链表数据为");
        Employ cruEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", cruEmp.id, cruEmp.name);
            if (cruEmp.next == null) {
                break;
            }
            cruEmp = cruEmp.next;
        }
        System.out.println();
    }

    //查找员工
    public Employ findById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employ curemp = head;
        while (true) {
            //说明找到
            if (curemp.id == id) {
                break;
            }
            //说明没找到需要返回null
            if (curemp.next == null) {
                curemp = null;
                break;
            }
            curemp = curemp.next;
        }
        return curemp;
    }

    public void deleteById(int id){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        Employ currEmp=head;
        //删除的是头节点，并且只有头节点一个
        if(currEmp.id==id&&currEmp.next==null){
            head=null;
            return;
        }if(currEmp.id==id&&currEmp.next!=null){
            head=head.next;
            System.out.println("删除成功");
            return;
        }
        while(true){
            //删除的是最后一个元素
            if(currEmp.next==null&&currEmp.id==id){
                currEmp=null;
                return;
            }
            if(currEmp.next==null&&currEmp.id!=id){
                System.out.println("未找到要删除的雇员");
                return;
            }
            if(currEmp.next.id==id){
                currEmp.next=currEmp.next.next;
                System.out.println("删除成功");
                return;
            }
            currEmp=currEmp.next;
        }
    }

}


/**
 * 雇员类
 */
class Employ {
    public int id;
    public String name;
    public Employ next;

    public Employ(int id, String name) {
        this.id = id;
        this.name = name;
    }
}