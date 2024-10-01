package com.jaideep.dsalgo.binarytree.dfs;

public class InvertABinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = dfs(node.left);
        node.left = dfs(node.right);
        node.right = left;
        return node;
    }
}
