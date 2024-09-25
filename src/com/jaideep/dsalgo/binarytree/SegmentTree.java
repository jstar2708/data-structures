package com.jaideep.dsalgo.binarytree;

public class SegmentTree {

    Node root;

    public void insert (int[] arr) {
        root = insert(root, arr, 0, arr.length-1);
    }

    private Node insert(Node node, int[] arr, int start, int end) {
        if (start == end) {
            node = new Node(arr[start], start, end);
            return node;
        }
        node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = insert(node.left, arr, start, mid);
        node.right = insert(node.right, arr, mid + 1, end);
        node.val = node.left.val + node.right.val;
        return node;
    }

    public void display() {
        display(root, "Root node : %d\n");
    }

    private void display(Node node, String message) {
        if (node == null) {
            return;
        }
        System.out.printf(message, node.val, node.start, node.end);
        if (node.left != null) {
            display(node.left, "Left node value of node " + node.val + " : %d, [%d, %d]\n");
        }
        if (node.right != null) {
            display(node.right, "Right node value of node " + node.val + " : %d, [%d, %d]\n");
        }
    }

    public int query(int start, int end) {
        return query(root, start, end);
    }

    private int query(Node node, int start, int end) {
        if (node == null) {
            return 0;
        }
        else if (node.start > end || node.end < start) {
            return 0;
        }
        else if (node.start >= start && node.end <= end) {
            return node.val;
        }
        return query(node.left, start, end) + query(node.right, start, end);
    }

    private static class Node {
        int val;
        int start;
        int end;
        Node left;
        Node right;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public Node(int val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
    }
}
