package com.jaideep.dsalgo.binarytree.dfs;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }
        TreeNode leftAns = helper(node.left, p, q);
        TreeNode rightAns = helper(node.right, p, q);
        if (leftAns != null && rightAns != null) {
            return node;
        }
        return leftAns == null ? rightAns : leftAns;
    }
}
