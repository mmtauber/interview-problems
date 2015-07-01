package com.radar.interview;

import com.radar.interview.dataStructures.BinaryTreeNode;
import com.radar.interview.recursion.Parens;

public class Main {

    private static int counter = -1;

    public static String serialize(BinaryTreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(BinaryTreeNode<Integer> x, StringBuilder sb){
        if (x == null) {
            sb.append("# ");
        } else {
            sb.append(x.getValue() + " ");
            serialize(x.getLeft(), sb);
            serialize(x.getRight(), sb);
        }
}

    public static BinaryTreeNode<Integer> deserialize(String s){
        if (s == null || s.length() == 0) return null;
        return deserialize(s.split(" "), counter);
    }

    private static BinaryTreeNode<Integer> deserialize(String[] st, int idx){
        if (idx >= st.length - 1)
            return null;
        counter++;
        String val = st[counter];
        if (val.equals("#")) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(Integer.valueOf(val));
        root.setLeft(deserialize(st, counter));
        root.setRight(deserialize(st, counter));
        return root;
    }


    public static void main(String[] args) {

        new Parens().runExample();


    }


}
