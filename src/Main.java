import com.jaideep.dsalgo.binarytree.AVLTree;
import com.jaideep.dsalgo.binarytree.BinarySearchTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3,4,5,6,7,8,9).collect(Collectors.toList());
        AVLTree bst = new AVLTree();
        for (int i : list) {
            bst.insert(i);
        }
        bst.display();
    }

}