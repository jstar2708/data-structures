package com.jaideep.dsalgo.binarytree;

import com.jaideep.dsalgo.binarytree.dfs.TreeNode;

public class ConvertSortedArrayToBST {
    TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
        populate(nums, 0, nums.length - 1);
        return root;
    }
    private void populate(int[] nums, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            root = insert(root, nums[mid]);
            populate(nums, low, mid - 1);
            populate(nums, mid + 1, high);
        }
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val > val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
    }

}
