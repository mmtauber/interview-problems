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

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = new BinaryTreeNode<>(left);
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = new BinaryTreeNode<>(right);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
