package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.Node;

/**
 * Created by radar on 3/2/15.
 */
public class AddTwoNumbers implements InterviewProblem {

    public Node<Integer> addTwoLL(Node<Integer> op1, Node<Integer> op2) {
        int add1 = getIntValue(op1, 1);
        int add2 = getIntValue(op2, 1);

        System.out.print("Adding operands " + add1 + " and " + add2);

        return getLLValue(add1 + add2);
    }

    private int getIntValue(Node<Integer> op1, int mult) {

        if (op1 == null) {
            return 0;
        }

        int val1 = getIntValue(op1.getNext(), mult * 10);
        int val2 = op1.getValue() * mult;

        return val1 + val2;
    }

    private Node<Integer> getLLValue(int num) {
        Node<Integer> node = null;
        Node<Integer> head = null;

        while (num > 0) {
            if (node != null) {
                node.setNext(new Node<>(num % 10));
                num /= 10;
                node = node.getNext();
            } else {
                head = new Node<>(num % 10);
                node = head;
                num /= 10;
            }
        }

        return head;
    }

    @Override
    public void runExample() {
        Node<Integer> op1 = new Node<>(5);
        op1.setNext(new Node<>(6));
        op1.getNext().setNext(new Node<>(7));

        Node<Integer> op2 = new Node<>(4);
        op2.setNext(new Node<>(2));
        op2.getNext().setNext(new Node<>(1));
        op2.getNext().getNext().setNext(new Node<>(1));

        addTwoLL(op1, op2);
    }
}
