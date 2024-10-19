package com.jaideep.dsalgo.binarytree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visitedNodes = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        preOrder(root, parentMap);
        findAllKDistanceNodes(target, parentMap, visitedNodes, ans, k, 0);
        return ans;
    }

    private void findAllKDistanceNodes(TreeNode node,
                                       Map<TreeNode, TreeNode> parentMap,
                                       Set<TreeNode> visitedNodes,
                                       List<Integer> ans,
                                       int k,
                                       int counter) {
        if (node == null || visitedNodes.contains(node)) {
            return;
        }
        visitedNodes.add(node);
        if (counter == k) {
            ans.add(node.val);
        }
        findAllKDistanceNodes(node.left, parentMap, visitedNodes, ans, k, counter + 1);
        findAllKDistanceNodes(node.right, parentMap, visitedNodes, ans, k, counter + 1);
        findAllKDistanceNodes(parentMap.get(node), parentMap, visitedNodes, ans, k, counter + 1);
    }

    private void preOrder(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
        }
        preOrder(node.left, parentMap);
        preOrder(node.right, parentMap);
    }


}
