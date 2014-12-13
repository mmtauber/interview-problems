package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by mark on 12/12/14.
 *
 * Reverse a linked list without recursion. Use O(1) space. Use O(n) time complexity.
 *
 *
 */
public class ReverseList implements InterviewProblem {

    public void reverseList(LinkedList list) {

        if (list == null) {
            return;
        }

        list.printList();

        Node pointerOne = list.getHead();
        Node pointerTwo = list.getHead().getNext();
        Node temp;

        if (pointerOne == null) {
            return;
        }

        if (pointerTwo == null) {
            return;
        }

        while (pointerTwo != null) {

            pointerOne.setNext(pointerTwo.getNext());

            temp = list.getHead();
            list.setHead(pointerTwo);
            list.getHead().setNext(temp);


            pointerTwo = pointerOne.getNext();

        }

        System.out.print("\n\nANSWER:\n");
        list.printList();

    }

    @Override
    public void runExample() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(3));
        list.add(new Node(6));
        list.add(new Node(7));
        list.add(new Node(12));

        reverseList(list);
    }
}
