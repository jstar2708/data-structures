package com.jaideep.dsalgo.binarytree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversalBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<NodeCoordinate>> map = new TreeMap<>();
        inorder(root, 0, 0, map);
        for (Map.Entry<Integer, List<NodeCoordinate>> e : map.entrySet()) {
            ans.add(e.getValue().stream().sorted((n1, n2) -> {
                if (n1.col > n2.col) {
                    return 1;
                } else if (n1.col == n2.col) {
                    if (n1.row > n2.row) {
                        return 1;
                    } else if (n1.row == n2.row) {
                        return Integer.compare(n1.node.val, n2.node.val);
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }

            }).map(n -> n.node.val).collect(Collectors.toList()));
        }
        return ans;
    }

    private void inorder(TreeNode node, int row, int col, Map<Integer, List<NodeCoordinate>> map) {
        if (node == null) {
            return;
        }
        inorder(node.left, row + 1, col - 1, map);
        if (map.containsKey(col)) {
            map.get(col).add(new NodeCoordinate(node, row, col));
        } else {
            List<NodeCoordinate> list = new ArrayList<>();
            list.add(new NodeCoordinate(node, row, col));
            map.put(col, list);
        }
        inorder(node.right, row + 1, col + 1, map);
    }

    private static class NodeCoordinate {
        TreeNode node;
        int row;
        int col;

        public NodeCoordinate(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
