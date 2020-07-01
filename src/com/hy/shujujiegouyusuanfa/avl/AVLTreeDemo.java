package com.hy.shujujiegouyusuanfa.avl;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyong
 * @date 2020/6/30 21:41
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.insert(new Node(i));
        }

        System.out.println("中遍历");

        avlTree.infixOrder();
        //System.out.println("没有旋转前");
        System.out.println("树的高度" + avlTree.getRootNode().height());
        System.out.println("左子树的高度" + avlTree.getRootNode().getLeft().height());
        System.out.println("右子树的高度" + avlTree.getRootNode().getRight().height());

        System.out.println("根节点是" + avlTree.getRootNode());
    }
}

@Getter
@Setter
class AVLTree {
    private Node rootNode;


    //查找要删除的节点
    public Node search(int value) {
        if (rootNode == null) {
            return null;
        } else {
            return rootNode.search(value);
        }
    }

    //查找要删的父节点
    public Node searchParent(int value) {
        if (rootNode == null) {
            return null;
        } else {
            return rootNode.searchParentNode(value);
        }
    }

    /**
     * 1.返回以node为根节点的二叉排序树的最小节点的值
     * 2.删除以node为根节点的树的最小节点
     *
     * @param node 传入的节点
     * @return 最小值
     */
    public int deleteRightTreeMin(Node node) {
        Node target = node;
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        deleteNode(target.getValue());
        return target.getValue();
    }

    public void deleteNode(int value) {
        if (rootNode == null) {
            return;
        }
        Node targetNode = rootNode.search(value);
        if (targetNode == null) {
            return;
        }
        //查到要删除的节点，但是该节点没有父节点，说明该节点是根节点
        if (rootNode.getLeft() == null && rootNode.getRight() == null) {
            rootNode = null;
            return;
        }
        Node parentNode = rootNode.searchParentNode(value);
        //删除叶子节点
        if (targetNode.getRight() == null && targetNode.getLeft() == null) {
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
                parentNode.setLeft(null);
            } else if (parentNode.getRight() != null && parentNode.getRight().getValue() == value) {
                parentNode.setRight(null);
            }
        } //删除的是有左子树也有右子树的节点
        else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            int minValue = deleteRightTreeMin(targetNode.getRight());
            targetNode.setValue(minValue);
        } else {//删除的是只有一个子树的节点
            //删除的额节点有右子树
            //说明删除节点是父节点的右子节点
            if (parentNode != null) {
                if (parentNode.getRight() != null) {
                    if (parentNode.getRight().getValue() == value) {
                        parentNode.setRight(targetNode.getRight());
                    } else {
                        parentNode.setLeft(targetNode.getRight());
                    }
                } else {
                    rootNode = targetNode.getRight();
                }

            } else {
                if (parentNode != null) {
                    if (parentNode.getRight().getValue() == value) {
                        parentNode.setRight(targetNode.getLeft());
                    } else {
                        parentNode.setLeft(targetNode.getLeft());
                    }
                } else {
                    rootNode = targetNode.getLeft();
                }
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (rootNode != null) {
            rootNode.prefix();
        } else {
            System.out.println("树为空，中序遍历毛线");
        }
    }

    //插入
    public void insert(Node node) {
        if (rootNode != null) {
            rootNode.insert(node);
        } else {
            rootNode = node;
        }
    }
}


@Getter
@Setter
class Node {
    private int value;
    private Node left;
    private Node right;

    /**
     * @return 返回左子树的高度
     */
    public int leftHeight() {
        return this.getLeft() == null ? 0 : this.getLeft().height();
    }

    /**
     * @return 返回右子树的高度
     */
    public int rightHeight() {
        return this.getRight() == null ? 0 : this.getRight().height();
    }

    /**
     * 返回当前节点的高度，以该节点为根节点的树的高度
     * 取左子树，右子树高度高的为当前节点的高度
     * 当前节点为第一层，即使只有当前节点也是1层，递归真tm牛
     *
     * @return
     */
    public int height() {
        return Math.max(this.getLeft() == null ? 0 : this.getLeft().height(), this.getRight() == null ? 0 : this.getRight().height()) + 1;
    }

    //左旋转
    public void leftRotata() {
        //创建新的节点，值是当前节点的值
        Node node = new Node(this.getValue());
        //新节点的左子树为当前节点的左子树
        node.setLeft(this.getLeft());
        //新节点的右子树为当前节点的右子树的左子树
        node.setRight(this.getRight().getLeft());
        //把当前节点的值变为当前节点的右子节点的值
        this.setValue(this.getRight().getValue());
        //把当前节点的右子树设置成当前节点的右子树的右子树
        this.setRight(this.getRight().getRight());
        //把当前节点的左子树设置为新的节点
        this.setLeft(node);
    }

    //右旋转
    public void rightRotate() {
        Node node = new Node(this.getValue());
        node.setRight(this.getRight());
        node.setLeft(this.getLeft().getRight());
        this.setValue(this.getLeft().getValue());
        this.setLeft(this.getLeft().getLeft());
        this.setRight(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    //中序遍历
    public void prefix() {
        if (this.left != null) {
            this.left.prefix();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.prefix();
        }
    }

    //插入
    public void insert(Node node) {
        if (node == null) {
            return;
        }
        //小于在左边，大于等于在右边
        if (node.getValue() < this.getValue()) {
            if (this.getLeft() == null) {
                this.setLeft(node);
            } else {
                this.getLeft().insert(node);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(node);
            } else {
                this.getRight().insert(node);
            }
        }
        //当添加完一个节点后，如果（右子树高度-左子树高度）>1 ,左旋转
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.getRight() != null && this.getRight().leftHeight() > this.getRight().rightHeight()) {
                this.getRight().rightRotate();
                leftRotata();
            } else {
                leftRotata();
            }
            return;
        }

        if (this.leftHeight() - this.rightHeight() > 1) {
            //如果当前节点的左子节点的右子树高度大于当前节点的左子节点的左子树高度
            if (this.getLeft() != null && this.getLeft().rightHeight() > this.getLeft().leftHeight()) {
                //当前节点的左子节点进行左旋转
                this.getLeft().leftRotata();
                //当前节点进行右旋转
                this.rightRotate();
            } else {
                rightRotate();
            }

        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.getLeft() == null) {
                return null;
            } else {
                return this.getLeft().search(value);
            }
        } else {
            if (this.getRight() == null) {
                return null;
            } else {
                return this.getRight().search(value);
            }
        }
    }

    //查找要删除的节点的父节点
    public Node searchParentNode(int value) {
        if ((this.getLeft() != null && this.getLeft().value == value) || (this.getRight() != null && this.getRight().value == value)) {
            return this;
        } else if (this.getLeft() != null && value < this.value) {
            return this.getLeft().searchParentNode(value);
        } else if (this.getRight() != null && value > this.value) {
            return this.getRight().searchParentNode(value);
        } else {
            return null;
        }
    }
}