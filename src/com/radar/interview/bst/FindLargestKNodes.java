package com.radar.interview.bst;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.BinaryTreeNode;

/**
 * Created by radar on 2/5/15.
 *
 * INCORRECT: Assumes 'k' would fit on a line down every node's right node starting from the root.
 *
 */
public class FindLargestKNodes implements InterviewProblem {
    
    public int[] findKLargest(BinaryTreeNode<Integer> node, int k) {
        int[] result = new int[k];
        int[] count = new int[1];
        
        findKLargestHelper(node, k, result, count);

        for (int num : result) {
            System.out.print("Result: " + num + "\n");
        }

        return result;
    }
    
    private void findKLargestHelper(BinaryTreeNode<Integer> node, int k, int[] result, int[] count) {
        
        if (node != null) {
            findKLargestHelper(node.getRight(), k, result, count);

            if (count[0] < k) {
                result[count[0]++] = node.getValue();
            }
        }
    }
    
    @Override
    public void runExample() {

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.setLeft(4);
        root.setRight(7);

        root.getRight().setLeft(6);
        root.getRight().setRight(11);
        root.getRight().getRight().setRight(14);

        findKLargest(root, 7);
        
    }
}
