package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by mark on 12/12/14.
 *
 * Remove the node that is k nodes from the last node in the list.
 *
 */
public class RemoveFromEnd implements InterviewProblem {

    public void removeFromTheEnd(LinkedList list, int k) {

        if (list == null || k == 0) {
            return;
        }

        list.printList();

        Node pointerOne = list.getHead();
        Node lookAhead = pointerOne;
        int count = 0;


        while (count < k) {
            lookAhead = lookAhead.getNext();
            count++;
        }

        while (lookAhead.getNext() != null) {
            lookAhead = lookAhead.getNext();
            pointerOne = pointerOne.getNext();
        }

        pointerOne.setNext( pointerOne.getNext().getNext() );

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

        removeFromTheEnd(list, 1);
    }
}
