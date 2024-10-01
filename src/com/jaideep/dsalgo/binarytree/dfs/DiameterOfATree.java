package com.jaideep.dsalgo.binarytree.dfs;

public class DiameterOfATree {
    public int diameterOfBinaryTree(TreeNode root) {
        int height = dfs(root);
        return mx;
    }

    int mx = -1;
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        mx = Math.max(mx, left + right);
        return Math.max(left, right) + 1;
    }
}
