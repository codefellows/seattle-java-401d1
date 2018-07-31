package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void add() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(12);
        tree.add(6);
        tree.add(2);
        tree.add(15);

        assertEquals(12, tree.getRoot().getData());
        assertEquals(15, tree.getRoot().getRight().getData());
        assertEquals(6, tree.getRoot().getLeft().getData());
        assertEquals(2, tree.getRoot().getLeft().getLeft().getData());
    }

    @Test
    public void testToString() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(12);
        tree.add(6);
        tree.add(2);
        tree.add(15);
        tree.toString();

        assertEquals("2 6 12 15 ", tree.toString());
    }
}