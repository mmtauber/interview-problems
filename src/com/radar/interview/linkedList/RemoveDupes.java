package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by mark on 12/12/14.
 *
 * Remove duplicates in a sorted list. O(n) time. O(1) space.
 *
 * IDEA: If next() is equal to current, keep the next() until it is different,
 * then assign the different node to the current node's next().
 *
 */
public class RemoveDupes implements InterviewProblem {

    public void removeDupes(LinkedList list) {

        if (list == null) {
            return;
        }

        list.printList();

        Node node = list.getHead();
        Node lookAhead = node;

        while (node != null) {

            while ( lookAhead.getNext() != null &&
                    lookAhead.getNext().getValue() == lookAhead.getValue()) {
                lookAhead = lookAhead.getNext();
            }

            node.setNext(lookAhead.getNext() == null ? null : lookAhead.getNext());
            lookAhead = lookAhead.getNext();
            node = node.getNext();

        }

        System.out.print("\n\nANSWER:\n" );
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
        list.add(new Node(12));
        list.add(new Node(12));
        list.add(new Node(12));
        list.add(new Node(12));

        removeDupes(list);
    }
}
