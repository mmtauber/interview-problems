package com.radar.interview.stack;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.Stack;

/**
 * @author mtauber
 */
public class FindMax implements InterviewProblem {

    public void findMax(Stack stack) {

        Stack<Integer> receiverStack = new Stack<>();
        int max = (int) stack.pop();
        int temp;

        receiverStack.push(max);

        while ( ! stack.isEmpty()) {

            temp = (int) stack.pop();

            if (temp > max) {
                max = temp;
            }

            receiverStack.push(temp);
        }

        System.out.print("\nANSWER: " + max);

    }

    @Override
    public void runExample() {

        Stack stack = new Stack();
        stack.push(10);
        stack.push(13);
        stack.push(8);
        stack.push(1);

        findMax(stack);
    }
}
