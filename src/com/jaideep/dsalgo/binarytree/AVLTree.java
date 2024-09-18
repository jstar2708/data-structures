package com.jaideep.dsalgo.binarytree;

import sun.security.util.KnownOIDs;

public class AVLTree {

    Node root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node selfBalance(Node node) {
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            // Left heavy
            if (getHeight(node.left.left) - getHeight(node.left.right) > 0) {
                // Left-left case, so right rotate
                return rightRotate(node);
            }
            if (getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // Left-right case, so left rotate and then right rotate
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (getHeight(node.left) - getHeight(node.right) < -1) {
            // Right heavy
            if (getHeight(node.right.left) - getHeight(node.right.right) < 0) {
                return leftRotate(node);
            }
            if (getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                // Right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node left = c.left;
        c.left = p;
        p.right = left;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;
        return c;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node right = c.right;
        c.right = p;
        p.left = right;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;
        return c;
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
        return selfBalance(node);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
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
