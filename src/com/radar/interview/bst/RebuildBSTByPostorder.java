package com.radar.interview.bst;

import com.radar.interview.InterviewProblem;

/**
 * Created by radar on 2/7/15.
 */
public class RebuildBSTByPostorder implements InterviewProblem {
              /*
    public BinaryTreeNode<Integer> rebuildBSTPostorder(int[] preorder) {
        int idx[] = {0};
        return rebuildPostorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, idx);
    }

    private BinaryTreeNode<Integer> rebuildPostorderHelper(int[] preorder, int min, int max, int[] idx) {

        if (idx[0] == preorder.length) {
            return null;
        }

        int curr = preorder[idx[0]];
        if (curr < min || curr > max) {
            return null;
        }

        idx[0]++;

        return new BinaryTreeNode<>(rebuildPostorderHelper(preorder, min, curr, idx),
                new BinaryTreeNode<BinaryTreeNode<Integer>>(curr),
                rebuildPostorderHelper(preorder, curr, max, idx));

    }
                   */
    @Override
    public void runExample() {

        int[] data = {20, 4, 6, 5, 7, 30, 21, 32};
        //BinaryTreeNode<Integer> ans = rebuildBSTPostorder(data);
        int t = 0;

    }
}
