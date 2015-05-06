package com.radar.interview.bst;

import com.radar.interview.InterviewProblem;
import com.radar.interview.dataStructures.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by radar on 4/28/15.
 */
public class PrintColumns implements InterviewProblem {

    Map<Integer, ArrayList<BinaryTreeNode>> map = new HashMap<>();
    int lo = 0;
    int hi = 0;

    public void printColumns(BinaryTreeNode node) {

        if (node == null) {
            return;
        }

        inOrderWalk(node, 0);

        for ( int i = lo; i <= hi; i++) {
            ArrayList<BinaryTreeNode> list = map.get(i);

            for(BinaryTreeNode iterNode : list) {
                System.out.print(iterNode.getValue());
            }
            System.out.print("\n");
        }


    }

    public void inOrderWalk(BinaryTreeNode node, int col) {

        if (node == null) {
            return;
        }

        lo = Math.min(col, lo);
        hi = Math.max(col, hi);

        if (map.containsKey(col)) {
            map.get(col).add(node);
        } else {
            ArrayList<BinaryTreeNode> list = new ArrayList<>();
            list.add(node);
            map.put(col, list);
        }

        inOrderWalk(node.getLeft(), col - 1);
        inOrderWalk(node.getRight(), col + 1);
    }


    @Override
    public void runExample() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode(5);
        root.setLeft(4);
        root.setRight(6);

        printColumns(root);
    }
}
