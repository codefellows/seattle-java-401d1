import static org.junit.Assert.*;

public class BinaryTreeTest {

    @org.junit.Test
    public void height() {
        BinaryTree tree = new BinaryTree();

        TreeNode n14 = new TreeNode(14);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n12 = new TreeNode(12);

        tree.root = n14;
        n14.left = n3;
        n14.right = n4;
        n3.right = n8;
        n8.right = n12;

        assertEquals(3, tree.height());
    }
}