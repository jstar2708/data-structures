package com.jaideep.dsalgo.binarytree.bfs;

import com.jaideep.dsalgo.binarytree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthSearchFirst {
    public void bfs(Queue<Node> queue) {
        if (queue.isEmpty())  {
            System.out.print("END");
            return;
        }
        Node node = queue.poll();
        System.out.print(node.val + "--> ");
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
        bfs(queue);
    }
}
