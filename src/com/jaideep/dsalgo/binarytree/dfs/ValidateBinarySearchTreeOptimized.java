package com.jaideep.dsalgo.binarytree.dfs;

public class ValidateBinarySearchTreeOptimized {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        else if (low != null && node.val <= low) {
            return false;
        }
        else if (high != null && node.val >= high) {
            return false;
        }
        return dfs(node.left, low, node.val) && dfs(node.right, node.val, high);

    }
}
