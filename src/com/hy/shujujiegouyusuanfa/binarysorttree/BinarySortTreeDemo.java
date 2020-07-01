package com.hy.shujujiegouyusuanfa.binarysorttree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyong
 * @date 2020/6/23 22:42
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] nums = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int num : nums) {
            binarySortTree.insert(new Node(num));
        }
        binarySortTree.infixOrder();

        binarySortTree.deleteNode(2);
        binarySortTree.deleteNode(5);
        binarySortTree.deleteNode(9);
        binarySortTree.deleteNode(12);
        binarySortTree.deleteNode(7);
        binarySortTree.deleteNode(3);
        binarySortTree.deleteNode(1);
        binarySortTree.deleteNode(10);

        System.out.println("删除节点后");
        binarySortTree.infixOrder();
    }
}


@Getter
@Setter
class BinarySortTree {
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