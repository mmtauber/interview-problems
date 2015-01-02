package com.radar.interview.stackQueue;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.LinkedList;
import com.radar.interview.dataStructures.Node;
import com.radar.interview.dataStructures.Stack;

/**
 * @author mtauber
 *
 * Given an arbitrarily complex pathname, simplify it to its shortest version.
 *
 */
public class PathName implements InterviewProblem {

    public void pathName(String path) {

        boolean isRoot = path.charAt(0) == '/';
        LinkedList<String> queue = split(path);

        Stack<String> stack = new Stack<>();
        String pathPart = queue.removeHead();

        while (pathPart != null) {

            // Don't push single dots
            switch (pathPart) {
                case ".":
                    pathPart = queue.removeHead();
                    break;

                // Check for an error condition on double dots.
                case "..":
                    if (stack.peek() == null) {
                        throw new IllegalStateException("You are trying to use '..' at the root!");
                    }

                    stack.pop();
                    pathPart = queue.removeHead();

                    break;

                // Push the word
                default:
                    stack.push(pathPart);
                    pathPart = queue.removeHead();
                    break;
            }
        }

        stack.printBackwards();
    }

    public LinkedList<String> split(String string) {
        LinkedList<String> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while(i < string.length()) {
            char c = string.charAt(i);

            if (c == '/' || i == string.length() - 1) {
                if (builder.length() != 0) {

                    if (i == string.length() - 1) {
                        builder.append(c);
                    }

                    // Else
                    Node<String> node = new Node<>(builder.toString());

                    // Clear builder
                    builder.delete(0 , builder.length());

                    queue.add(node);
                }
            } else {
                builder.append(c);
            }
            i++;

        }

        return queue;
    }

    @Override
    public void runExample() {
        pathName("usr/local/../stuff/.//bin");
    }
}
