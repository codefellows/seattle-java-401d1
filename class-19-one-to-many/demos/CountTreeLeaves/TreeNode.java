public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    // returns true if this node is a "leaf" and has nothing below it.
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}