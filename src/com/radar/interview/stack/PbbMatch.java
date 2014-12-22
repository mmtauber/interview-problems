package com.radar.interview.stack;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.Stack;

/**
 * @author mtauber
 *
 * Paraen, bracket, brace matcher. Match opening and closing PBBs. Return true
 * if there are no mismatches.
 *
 */
public class PbbMatch implements InterviewProblem {

    public boolean pbbMatch(String input) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                    stack.push("(");
                    break;
                case '[':
                    stack.push("[");
                    break;
                case '{':
                    stack.push("{");
                    break;
                case ')':
                    if ( ! stack.peek().equals("(")) {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if ( ! stack.peek().equals("[")) {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if ( ! stack.peek().equals("{")) {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }

    @Override
    public void runExample() {
]
        String input = "{([])}";

        System.out.print("\nANSWER: " + pbbMatch(input));
    }
}
