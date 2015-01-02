package com.radar.interview.dataStructures;

/**
 * @author mtauber
 */
public class LinkedList<T> {

    private Node<T> head;
    private int length;

    public T removeHead() {

        if (head == null) {
            return null;
        }

        Node<T> temp = head;
        this.setHead(head.getNext());
        return temp.getValue();
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void add(Node<T> node) {

        if (node != null) {
            if (head != null) {
                Node<T> next = head;

                while (next.getNext() != null) {
                    next = next.getNext();
                }

                next.setNext(node);
            } else {
                head = node;
            }

            length++;
        }
    }

    public void printList() {

        Node node = head;

        while (node != null) {

            System.out.print("Value: " + node.getValue() + "\n");
            node = node.getNext();
        }

    }
}
