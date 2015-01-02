package com.radar.interview.stackQueue;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.Stack;

/**
 * @author mtauber
 *
 * Return the longest valid substring of open/close parens!!
 *
 */
public class ParenSubstring implements InterviewProblem {

    public void parenSubstring(String input) {

        Stack<Integer> stack = new Stack<>();
        int lastEnd = 0;
        int maxLength = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {

                if (stack.isEmpty()) {
                    lastEnd = i + 1;
                } else {
                    stack.pop();
                    int start = stack.isEmpty() ? lastEnd - 1 : stack.peek();
                    maxLength = Math.max(maxLength, i - start);
                }
            }
        }

        System.out.print("\nANSWER: " + maxLength);

    }

    @Override
    public void runExample() {
        String input = "(())())()";
        parenSubstring(input);
    }
}
