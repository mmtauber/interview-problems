package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;

/**
 * Created by mark on 12/12/14.
 *
 * Given two lists that merge eventually, find the first node that is common b/t the
 * two lists.
 *
 */
public class OverlappingLists implements InterviewProblem {

    public void detectOverlap(LinkedList list1, LinkedList list2) {

        if (list1 == null || list2 == null) {
            return;
        }

        System.out.print("\nFirst list:\n\n");
        list1.printList();
        System.out.print("Second list:\n");
        list2.printList();

        int length1 = 0, length2 = 0;
        Node node1 = list1.getHead(), node2 = list2.getHead();

        // Get the length of each list.
        while (node1 != null) {
            length1++;
            node1 = node1.getNext();
        }

        while (node2 != null) {
            length2++;
            node2 = node2.getNext();
        }
        
        // Reset node pointers to the HEAD of their respective lists.
        node1 = list1.getHead();
        node2 = list2.getHead();
        
        // Get the difference in length b/t the two lists.
        // Move the longer list's point until the remaining nodes in each list are equal.
        int diff = 0;
        if (length1 > length2) {
            
            diff = length1 - length2;
            
            for (int i = 0; i < diff; i++) {
                node1 = node1.getNext();
            }
            
        } else {

            diff = length2 - length1;

            for (int j = 0; j < diff; j++) {
                node2 = node2.getNext();
            }
            
        }

        while ( ! node1.equals(node2)) {
            node1 = node1.getNext();
            node2 = node2.getNext();
        }

        System.out.print("\n\nCOMMON NODE VALUE:\n" + node1.getValue());
    }

    // Detect the overlap by nulling out all of the pointers in one list.
    //
    // The intersecting node is the one where the first null node is found by
    // iterating the second list.
    // Slight efficiency gains can be attained using this algorithm.
    // O(n1 + (n1 - n2)) || O(n2 (n2 - n1))
    public void detectOverlap2(LinkedList list1, LinkedList list2) {

        if (list1 == null || list2 == null) {
            return;
        }

        System.out.print("\nFirst list:\n\n");
        list1.printList();
        System.out.print("Second list:\n");
        list2.printList();

        Node node1 = list1.getHead(), node2 = list2.getHead(), temp = null;

        // Null all next pointers in one list
        while (node1 != null) {
            temp = node1;
            node1 = node1.getNext();
            temp.setNext(null);
        }

        while (node2.getNext() != null) {
            node2 = node2.getNext();
        }

        System.out.print("\nCOMMON NODE VALUE:\n" + node2.getValue());
    }


    @Override
    public void runExample() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(3));
        list.add(new Node(7));
        list.add(new Node(11));
        list.add(new Node(14));

        LinkedList list2 = new LinkedList();
        list2.add(new Node(99));
        list2.add(new Node(98));

        // Link second list to first list at third node in first list.
        list2.getHead().getNext().setNext(list.getHead().getNext().getNext());

        detectOverlap(list, list2);
        detectOverlap2(list, list2);
    }
}