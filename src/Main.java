import com.jaideep.dsalgo.binarytree.BinarySearchTree;
import com.jaideep.dsalgo.binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < 10; i++) {
            binarySearchTree.insert(new Random().nextInt(100));
        }
        Queue<Node> queue = new LinkedList<>();
    }

}