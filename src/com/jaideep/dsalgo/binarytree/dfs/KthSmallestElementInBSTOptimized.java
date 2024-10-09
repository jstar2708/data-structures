package com.jaideep.dsalgo.binarytree.dfs;

public class KthSmallestElementInBSTOptimized {
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, new int[]{0}, k).val;
    }

    private TreeNode inorder(TreeNode node, int[] counter, int k) {
        if (node == null) {
            return null;
        }
        TreeNode left = inorder(node.left, counter, k);
        if (left != null) {
            return left;
        }
        counter[0]++;
        if (counter[0] == k) {
            return node;
        }
        return inorder(node.right, counter, k);
    }
}
