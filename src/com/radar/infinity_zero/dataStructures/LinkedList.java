package com.radar.infinity_zero.dataStructures;

/**
 * @author mtauber
 */
public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(Node node) {

        if (head != null) {
            Node next = head.getNext();

            while (next.getNext() != null) {
                next = next.getNext();
            }

            next.setNext(node);
        }


        //output error here.
    }
}
