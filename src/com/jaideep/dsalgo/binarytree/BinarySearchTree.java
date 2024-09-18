package com.jaideep.dsalgo.binarytree;

public class BinarySearchTree {
    Node root;

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            root = insert(root, val);
        }
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (node.val > val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    public void display() {
        display(root, "Root node : %d\n");
    }

    private void display(Node node, String message) {
        if (node == null) {
            return;
        }
        System.out.printf(message, node.val);
        if (node.left != null) {
            display(node.left, "Left node value of node " + node.val + " : %d\n");
        }
        if (node.right != null) {
            display(node.right, "Right node value of node " + node.val + " : %d\n");
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
