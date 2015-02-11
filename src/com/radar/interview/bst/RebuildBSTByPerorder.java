package com.radar.interview.bst;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.BinaryTreeNode;

/**
 * Created by radar on 2/7/15.
 */
public class RebuildBSTByPerorder implements InterviewProblem {

    public BinaryTreeNode<Integer> rebuildBSTPreorder(int[] preorder) {
        int idx[] = {0};
        return rebuildPreorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, idx);
    }

    private BinaryTreeNode<Integer> rebuildPreorderHelper(int[] preorder, int min, int max, int[] idx) {

        if (idx[0] == preorder.length) {
            return null;
        }

        int curr = preorder[idx[0]];
        if (curr < min || curr > max) {
            return null;
        }

        idx[0]++;

        return new BinaryTreeNode<>(curr,
                rebuildPreorderHelper(preorder, min, curr, idx),
                rebuildPreorderHelper(preorder, curr, max, idx));

    }

    @Override
    public void runExample() {

        int[] data = {20, 4, 6, 5, 7, 30, 21, 32};
        BinaryTreeNode<Integer> ans = rebuildBSTPreorder(data);
        int t = 0;

    }
}
