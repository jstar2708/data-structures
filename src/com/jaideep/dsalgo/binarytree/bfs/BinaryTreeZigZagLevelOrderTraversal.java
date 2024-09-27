package com.jaideep.dsalgo.binarytree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        bfs(queue, ans);
        return ans;
    }

    private void bfs(ArrayDeque<TreeNode> queue, List<List<Integer>> ans) {
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (isReverse) {
                    node = queue.pollLast();
                    if (node == null) {
                        return;
                    }
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                } else {
                    node = queue.poll();
                    if (node == null) {
                        return;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                list.add(node.val);
            }
            isReverse = !isReverse;
            ans.add(list);
        }
    }
}
