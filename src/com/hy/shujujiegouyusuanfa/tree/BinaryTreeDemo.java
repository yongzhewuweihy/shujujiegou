package com.hy.shujujiegouyusuanfa.tree;

import lombok.*;

/**
 * @author hanyong
 * @date 2020/6/10 22:33
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRootNode(root);

        binaryTree.preOrder();

//        binaryTree.deleteByNo(3);
        //binaryTree.deleteByNo2(3);
        System.out.println("删除后");
        binaryTree.preOrder();

        //System.out.println(binaryTree.infixOrderSearch(5));
//       System.out.println(binaryTree.postOrderSearch(5));

        /*//前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("后续序遍历");
        binaryTree.postOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();*/
    }
}

@Getter
@Setter
class BinaryTree {
    private HeroNode rootNode;

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