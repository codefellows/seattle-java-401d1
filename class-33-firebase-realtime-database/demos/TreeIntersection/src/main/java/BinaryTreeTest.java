package main.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTree<Integer> t1;
    BinaryTree<Integer> t2;
    BinaryTree<Integer> empty;

    Set<Integer> emptySet = new HashSet<>();

    @Before
    public void makeTrees() {
        t1 = new BinaryTree<>();
        t2 = new BinaryTree<>();
        empty = new BinaryTree<>();

        t1.root = new TreeNode<>(4);
        t1.root.left = new TreeNode<>(2);
        t1.root.right = new TreeNode<>(1);

        t2.root = new TreeNode<>(23);
        t2.root.left = new TreeNode<>(9);
        t2.root.right = new TreeNode<>(4);
    }

    @org.junit.Test
    public void emptyTree() {
        Set<Integer> actual1 = BinaryTree.intersect(t1, empty);
        Set<Integer> actual2 = BinaryTree.intersect(t2, empty);

        assertEquals(actual1, emptySet);
        assertEquals(actual2, emptySet);
    }

    @org.junit.Test
    public void oneMatch() {
        Set<Integer> actual = BinaryTree.intersect(t1, t2);

        Set<Integer> expected = new HashSet<>();
        expected.add(4);

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void complex() {
        BinaryTree<Integer> t1 = new BinaryTree<>();

        t1.root = new TreeNode<>(150);
        t1.root.left = new TreeNode<>(100);
        t1.root.left.left = new TreeNode<>(75);

        t1.root.left.right = new TreeNode<>(160);
        t1.root.left.right.left = new TreeNode<>(125);
        t1.root.left.right.right = new TreeNode<>(175);

        t1.root.right = new TreeNode<>(250);
        t1.root.right.left = new TreeNode<>(200);
        t1.root.right.right = new TreeNode<>(350);

        t1.root.right.right = new TreeNode<>(350);
        t1.root.right.right.left = new TreeNode<>(300);
        t1.root.right.right.right = new TreeNode<>(500);

        BinaryTree<Integer> t2 = new BinaryTree<>();

        t2.root = new TreeNode<>(42);
        t2.root.left = new TreeNode<>(100);
        t2.root.left.left = new TreeNode<>(15);

        t2.root.left.right = new TreeNode<>(160);
        t2.root.left.right.left = new TreeNode<>(125);
        t2.root.left.right.right = new TreeNode<>(175);

        t2.root.right = new TreeNode<>(600);
        t2.root.right.left = new TreeNode<>(200);
        t2.root.right.right = new TreeNode<>(350);

        t2.root.right.right = new TreeNode<>(350);
        t2.root.right.right.left = new TreeNode<>(4);
        t2.root.right.right.right = new TreeNode<>(500);

        Set<Integer> expected = new HashSet<>();
        expected.add(100);
        expected.add(160);
        expected.add(125);
        expected.add(175);
        expected.add(200);
        expected.add(350);
        expected.add(500);

        assertEquals(expected, BinaryTree.intersect(t1, t2));
        assertEquals(expected, BinaryTree.intersect(t2, t1));
    }
}