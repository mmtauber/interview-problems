package com.radar.interview.dataStructures;

/**
 * @author mtauber
 */
public class BinaryTreeNode <T> {

    private T value;
    private BinaryTreeNode<T> left = null, right = null ;

    public BinaryTreeNode(T value) {

        this.value = value;

    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {

        this.value = value;
        this.left = leftNode;
        this.right = rightNode;

    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = new BinaryTreeNode<>(left);
    }
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = new BinaryTreeNode<>(right);
    }
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
