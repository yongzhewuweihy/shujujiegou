package com.hy.shujujiegouyusuanfa.tree.threadedbinarytree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyong
 * @date 2020/6/15 20:41
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree();
        threadedBinaryTree.setRootNode(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1

        threadedBinaryTree.threadedBinaryTreeList();
    }
}

@Getter
@Setter
//线索化二叉树
class ThreadedBinaryTree {
    private HeroNode rootNode;

    private HeroNode preNode=null;
    public void threadedNodes(){
        this.threadedNodes(rootNode);
    }

    //中序化遍历
    public void threadedBinaryTreeList(){
        HeroNode node=rootNode;
        while(node!=null){
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);

            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            //不是后继节点则替换这个遍历的节点
            node=node.getRight();

        }
    }

    public void threadedNodes(HeroNode node){
        if(node==null){
            return;
        }
        //左
        threadedNodes(node.getLeft());
        //当前1.先设置前驱
        if(node.getLeft()==null){
            node.setLeft(preNode);
            //1代表前驱是节点
            node.setLeftType(1);
        }
        //设置后继
        if(preNode!=null&&preNode.getRight()==null){
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        //后移使当前节点变成前驱节点
        preNode=node;
        //右
        threadedNodes(node.getRight());
    }

    //前序
    public void preOrder() {
        if (this.rootNode != null) {
            this.rootNode.preOrder();

        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    //后序
    public void postOrder() {
        if (this.rootNode != null) {
            this.rootNode.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序
    public void infixOrder() {
        if (this.rootNode != null) {
            this.rootNode.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.rootNode != null) {
            return this.rootNode.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.rootNode != null) {
            return this.rootNode.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.rootNode != null) {
            return this.rootNode.infixOrderSearch(no);
        } else {
            return null;
        }
    }


    public void deleteByNo(int no) {
        if (rootNode != null) {
            if (rootNode.getNo() == no) {
                rootNode = null;
            } else {
                rootNode.deleteByNo(no);
            }
        } else {
            System.out.println("空树不能删除");
        }

    }


}


@Setter
@Getter
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //如果leftType==0，表示指向的是左子树，如果是1则表示指向前驱节点
    //如果rightType==0，表示指向的是右子树，如果是1则表示指后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序查找");
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        System.out.println("后序查找");
        if (this.no == no) {
            heroNode = this;
        }
        return heroNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.infixOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        System.out.println("中序查找");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }


    //删除策略 1.叶子节点直接删除 2.非叶子节点删除查找到的整个子树
    public void deleteByNo(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //以上不满足，向左递归去删除
        if (this.left != null) {
            this.left.deleteByNo(no);
            //此处不return的原因是如果找到会进行删除，如果没有找到后面需要进行右递归
        }
        //向右递归
        if (this.right != null) {
            this.right.deleteByNo(no);
        }
    }


}
