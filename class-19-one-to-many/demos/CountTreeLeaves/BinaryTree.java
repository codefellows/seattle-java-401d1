public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public int height() {
       return height(this.root);
    }

    private int height(TreeNode node) {
        // https://en.wikipedia.org/wiki/Tree_(data_structure)
        // "The height of a node is the number of edges on the longest path
        //  between that node and a leaf."
        // therefore: leaf nodes have a height of zero.
        if (node == null || node.left == null && node.right == null) {
            return 0;
        }

        int leftHeight = 1 + height(node.left);
        int rightHeight = 1 + height(node.right);
        return Math.max(leftHeight, rightHeight);
    }
}
