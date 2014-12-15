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
public class ReverseListByIndexes implements InterviewProblem {

    public void reverseListByIndexes(LinkedList list, int start, int stop) {

        int count = 0;

        if (list == null) {
            return;
        }

        list.printList();

        Node beforeNode = null;
        Node pointerOne = list.getHead();

        // Find our starting position
        while (count < start) {

            if (count == start - 1) {
                beforeNode = pointerOne;
            }
            if (pointerOne != null) {
                pointerOne = pointerOne.getNext();
                count++;
            }

        }

        Node pointerTwo = null;
        Node indexHead = pointerOne;
        Node temp;

        if (pointerOne != null) {
            pointerTwo = pointerOne.getNext();
        }

        while (count < stop) {

            pointerOne.setNext(pointerTwo.getNext());

            temp = indexHead;
            indexHead = pointerTwo;
            indexHead.setNext(temp);

            pointerTwo = pointerOne.getNext();

            count++;
        }

        beforeNode.setNext(indexHead);

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

        reverseListByIndexes(list, 1, 3);
    }
}
