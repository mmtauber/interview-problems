package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by mark on 12/12/14.
 *
 * Any node shifted "out" of the list must move to the front.
 *
 * Ex. 1 2 3 (Shift 2) = 2 3 1
 *
 */
public class CyclicalShift implements InterviewProblem {

    public void cyclicalShift(LinkedList list, int k) {

        if (list == null || k == 0) {
            return;
        }

        list.printList();

        Node pointerOne = list.getHead();
        Node lookAhead = pointerOne;
        int count = 0;


        while (count < k + 1) {
            lookAhead = lookAhead.getNext();
            count++;
        }

        // Move pointer group to the end of the list.
        while (lookAhead.getNext() != null) {
            lookAhead = lookAhead.getNext();
            pointerOne = pointerOne.getNext();
        }

        // Break at what will be the new end of list.
        Node temp = pointerOne.getNext().getNext();
        pointerOne.getNext().setNext(null);

        // Set lookahead to the head of the list
        Node oldHead = list.getHead();
        list.setHead(temp);
        lookAhead.setNext(oldHead);

        System.out.print("\n\nANSWER:\n");
        list.printList();

    }

    @Override
    public void runExample() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(3));
        list.add(new Node(6));
        list.add(new Node(7));
        list.add(new Node(7));
        list.add(new Node(11));
        list.add(new Node(12));
        list.add(new Node(13));
        list.add(new Node(14));

        cyclicalShift(list, 3);
    }
}