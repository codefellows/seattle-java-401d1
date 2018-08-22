package main.java;

import java.util.HashSet;
import java.util.Set;

public class BinaryTree<E> {
    public TreeNode<E> root;

    public Set<E> getValues() {
        Set<E> values = new HashSet<>();
        collectValues(this.root, values);
        return values;
    }

    private void collectValues(TreeNode<E> node, Set<E> values) {
        if (node != null) {
            values.add(node.data);
            collectValues(node.left, values);
            collectValues(node.right, values);
        }
    }

    public static Set intersect(BinaryTree t1, BinaryTree t2) {
        Set v1 = t1.getValues();
        Set v2 = t2.getValues();

        v1.retainAll(v2);
        return v1;
    }
}
