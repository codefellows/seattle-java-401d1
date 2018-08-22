package main.java;

public class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
    }
}
