package com.jaideep.dsalgo.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulationNextPointersInEachNode {

    private Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        bfs(queue);
        return root;
    }

    private Node connectOpt(Node root) {
        if (root == null) {
            return null;
        }
        Node current = root;
        Node leftMost = current.left;
        while (leftMost != null) {
            current.left.next = current.right;
            if (current.next != null) {
                current.right.next = current.next.left;
                current = current.next;
            }
            else {
                current = leftMost;
                leftMost = current.left;
            }
        }
        return root;
    }

    private void bfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node node;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node == null) {
                    return;
                }
                if (i != size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
