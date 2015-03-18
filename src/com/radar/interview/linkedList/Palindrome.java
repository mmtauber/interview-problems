package com.radar.interview.linkedList;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.Node;

import java.util.Objects;

/**
 * Created by radar on 3/3/15.
 */
public class Palindrome implements InterviewProblem {


    public boolean isPal(Node<Integer> head) {
        Result r = isPalHalp(head, 4); // Change second param when LL length changes.
        return r.result;
    }

    private Result isPalHalp(Node<Integer> head, int length) {

        if (head == null || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head.getNext(), true);
        } else if (length == 2) {
            return new Result(head.getNext().getNext(), head.getValue() == head.getNext().getValue());
        }

        Result result = isPalHalp(head.getNext(), length - 2);
        if ( ! result.result || result.node == null) {
            return result;
        } else {
            result.result = Objects.equals(head.getValue(), result.node.getValue());
            result.node = result.node.getNext();
            return result;
        }
    }

    private class Result {
        Node<Integer> node;
        boolean result;

        public Result(Node<Integer> node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    @Override
    public void runExample() {

        Node<Integer> head = new Node<>(1);
        head.setNext(new Node<>(2));
        head.getNext().setNext(new Node<>(2));
        head.getNext().getNext().setNext(new Node<>(2));

        System.out.print(isPal(head));

    }
}
