package com.jaideep.dsalgo.binarytree.bfs;

import javafx.util.Pair;

import java.util.ArrayDeque;

public class MaximumWidthOfABinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int mxWidth = 1;
        ArrayDeque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                int first = queue.peekFirst().getValue();
                int last = queue.peekLast().getValue();
                mxWidth = Math.max(Math.abs(last - first) + 1, mxWidth);
            }
            for (int i = 0; i < size; i ++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode node = p.getKey();
                int counter = p.getValue();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * counter + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * counter + 2));
                }
            }
        }
        return mxWidth;
    }
}
