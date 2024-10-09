package com.jaideep.dsalgo.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k - 1);
    }

    private void inorder(TreeNode node, List<Integer> list, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, list, k);
        list.add(node.val);
        inorder(node.right, list, k);
    }
}
