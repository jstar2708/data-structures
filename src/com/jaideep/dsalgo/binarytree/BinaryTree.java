package com.jaideep.dsalgo.binarytree;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.Scanner;

public class BinaryTree {
    private static final Scanner scanner = new Scanner(System.in);
    private Node root;

    public void insert() {
        System.out.println("Enter value for root node : ");
        root = new Node(scanner.nextInt());
        insert(root);
    }

    private void insert(Node node) {
        System.out.print("Do you want to enter in left node ?");
        boolean ch = scanner.nextBoolean();
        if (ch) {
            System.out.print("Enter value for left node : ");
            node.left = new Node(scanner.nextInt());
            insert(node.left);
        }
        System.out.print("Do you want to enter in right node ?");
        ch = scanner.nextBoolean();
        if (ch) {
            System.out.print("Enter value for right node : ");
            node.right = new Node(scanner.nextInt());
            insert(node.right);
        }
    }

    public void display() {
        display(root, "Enter value for root node : %d\n");
    }

    private void display(Node node, String message) {
        if (node == null) {
            return;
        }
        System.out.printf(message, node.val);
        if (node.left != null) {
            display(node.left, "Left Node value : %d\n");
        }
        if (node.right != null) {
            display(node.right, "Right node value : %d\n");
        }
    }

    private static class Node {
        int val;
        Node left;
        Node right;

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
