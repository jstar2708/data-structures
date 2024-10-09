package com.jaideep.dsalgo.binarytree.dfs;

public class FlattenABinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        while (node != null) {
            if (node.left != null) {
                TreeNode temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = node.right;
                node.right = node.left;
            }
            node = node.right;
        }
    }
}
