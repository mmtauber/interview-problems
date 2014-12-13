package com.radar.interview.dataStructures;

/**
 * @author mtauber
 */
public class LinkedList {

    private Node head;
    private int length;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void add(Node node) {

        if (node != null) {
            if (head != null) {
                Node next = head;

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
