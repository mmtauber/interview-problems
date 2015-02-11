package com.radar.interview.bst;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by radar on 2/11/15.
 *
 * Using a non-decreasing sorted doubly-linked list of integers create a balanced BST.
 *
 */
public class DoubleLinkedListToBST implements InterviewProblem {

    private static Node<Integer> head;

    public Node<Integer> doubleLinkedListToBST(Node<Integer> L, int n) {
        Node<Integer> result = doubleLinkedListToBSTHelper(0, n);
        return result;
    }

    private Node<Integer> doubleLinkedListToBSTHelper(int s, int e) {

        if (s >= e) {
            return null;
        }

        int m = s + ((e - s) / 2);
        Node<Integer> tempLeft = doubleLinkedListToBSTHelper(s, m);
        Node<Integer> curr = new Node<>(head.getValue());
        head = head.getNext();

        curr.setPrev(tempLeft);
        curr.setNext(doubleLinkedListToBSTHelper(m + 1, e));

        return curr;
    }

    @Override
    public void runExample() {

        LinkedList<Integer> L = new LinkedList<>();
        L.add(new Node<>(2));
        L.add(new Node<>(3));
        L.add(new Node<>(4));
        L.add(new Node<>(11));
        L.add(new Node<>(12));
        L.add(new Node<>(15));
        L.add(new Node<>(17));

        head = L.getHead();

        doubleLinkedListToBST(head, L.getLength());

    }
}
