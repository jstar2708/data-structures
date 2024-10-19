package com.jaideep.dsalgo.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();
        if (root == null) {
            return list;
        }
        stackOne.push(root);
        while (!stackOne.isEmpty()) {
            TreeNode node = stackOne.pop();
            if (node.left != null) {
                stackOne.push(node.left);
            }
            if (node.right != null) {
                stackOne.push(node.right);
            }
            stackTwo.push(node.val);
        }
        while (!stackTwo.isEmpty()) {
            list.add(stackTwo.pop());
        }
        return list;
    }
}
