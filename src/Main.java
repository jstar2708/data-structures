import com.jaideep.dsalgo.binarytree.BinarySearchTree;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(95, 80, 96, 18, 32, 6, 6, 89, 83, 6);
        BinarySearchTree bst = new BinarySearchTree();
        for (int i : list) {
            bst.insert(i);
        }
        bst.preOrderTraversal();
    }

}