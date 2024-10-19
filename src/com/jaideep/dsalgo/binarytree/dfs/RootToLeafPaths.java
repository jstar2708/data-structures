package com.jaideep.dsalgo.binarytree.dfs;

import com.jaideep.dsalgo.binarytree.Node;

import java.util.ArrayList;

public class RootToLeafPaths {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, ans);
        return ans;
    }

    private static void dfs(Node node, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(list));
        }
        dfs(node.left, list, ans);
        dfs(node.right, list, ans);
        list.remove(list.size() - 1);
    }
}
