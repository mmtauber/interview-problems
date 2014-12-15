package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by mark on 12/12/14.
 *
 * Detect a cycle. Return the cycling node if a cycle exists. Specifically,
 * return the node at the beginning of the cycle.
 *
 */
public class DetectCycle implements InterviewProblem {

    public void detectCycle(LinkedList list) {

        if (list == null) {
            return;
        }

        Node slowPointer = list.getHead();

        if (slowPointer == null) {
            return;
        }

        Node fastPointer = slowPointer.getNext();

        if (fastPointer == null) {
            return;
        }

        // Search for cycle, exit if null found (no cycle).
        while ( ! fastPointer.equals(slowPointer)) {

            if (fastPointer.getNext() == null) {
                // No cycle
            }
            if (fastPointer.getNext().getNext() == null) {
                // No cycle
            }

            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }

        // At this point both pointers have collided.
        while (fastPointer.getNext() != null) {
            fastPointer = fastPointer.getNext();
            slowPointer.setNext(null);
            slowPointer = fastPointer;
        }

        slowPointer = list.getHead();

        while (slowPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
        }

        System.out.print("\n\nANSWER: Node value: " + slowPointer.getValue());

    }

    @Override
    public void runExample() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(3));
        list.add(new Node(6));
        list.add(new Node(7));
        list.add(new Node(12));

        // Create cycle
        Node node6 = list.getHead().getNext().getNext();

        // Last node cycles to node with value = 6.
        node6.getNext().getNext().setNext(node6);

        detectCycle(list);
    }
}
