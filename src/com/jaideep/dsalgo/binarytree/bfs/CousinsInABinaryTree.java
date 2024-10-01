package com.jaideep.dsalgo.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInABinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return bfs(queue, x, y);
    }

    private boolean bfs(Queue<TreeNode> queue, int x, int y) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null) {
                        if (node.left.val == x) {
                            foundX = true;
                        } else if (node.left.val == y) {
                            foundY = true;
                        }
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        if (node.right.val == x) {
                            foundX = true;
                        } else if (node.right.val == y) {
                            foundY = true;
                        }
                        queue.offer(node.right);
                    }
                    if (node.left != null && node.right != null && ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x))) {
                        return false;
                    }
                }
            }
            if (foundX && foundY) {
                return true;
            }
        }
        return false;
    }
}
