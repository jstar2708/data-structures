package com.jaideep.dsalgo.binarytree.bfs;

import com.jaideep.dsalgo.binarytree.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfABinaryTree {
    public ArrayList<Integer> bottomView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        preorder(root, 0, 0, map);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

    private void preorder(Node node, int row, int col, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(col, node.val);
        preorder(node.left, row + 1, col - 1, map);
        preorder(node.right, row + 1, col + 1, map);
    }
}
