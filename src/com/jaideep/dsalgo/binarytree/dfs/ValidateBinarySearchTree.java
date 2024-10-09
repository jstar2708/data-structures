package com.jaideep.dsalgo.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    public boolean inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            if (list.size() >= 2 && list.get(list.size() - 1) <= list.get(list.size() - 2)) {
                return false;
            }
            root = root.right;

        }
        return true;
    }
}
