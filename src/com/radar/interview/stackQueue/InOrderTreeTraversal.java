package com.radar.interview.stackQueue;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.BinaryTreeNode;
import com.radar.interview.dataStructures.Stack;

/**
 * @author mtauber
 */
public class InOrderTreeTraversal implements InterviewProblem {

    public void inOrderTreeTraversal(BinaryTreeNode<Integer> tree) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        boolean loopAgain = false;
        boolean checkLeft = true;

        BinaryTreeNode current = tree;

        do {

            if (current.getLeft() != null && checkLeft) {

                // Push current on stack
                stack.push(current);
                current = current.getLeft();
                continue;

            }

            loopAgain = false;
            checkLeft = true;

            // Print current
            System.out.print("\nVal: " + current.getValue());

            if (current.getRight() != null) {
                current = current.getRight();
                loopAgain = true;
                continue;
            }

            // Stuff still on stack? Pop it!
            if ( ! stack.isEmpty()) {
                // Pop and assign to current
                current = stack.pop();
                loopAgain = true;
                checkLeft = false;
            }

        } while ( ! stack.isEmpty() || loopAgain);

    }

    @Override
    public void runExample() {

        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(10);
        tree.setLeft(7);
        tree.setRight(11);
        tree.getLeft().setLeft(6);
        tree.getLeft().getLeft().setLeft(1);
        tree.getLeft().getLeft().setRight(8);
        tree.getLeft().getLeft().getRight().setLeft(2);
        tree.getLeft().getLeft().getRight().setRight(9);

        tree.getRight().setRight(12);


        inOrderTreeTraversal(tree);
    }
}
