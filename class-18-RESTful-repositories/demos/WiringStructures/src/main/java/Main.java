import com.sun.source.tree.BinaryTree;

public class Main {
    //      45
    //    /   \
    //  66     66
    //    \   /
    //   66  66
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();

        TreeNode n45 = new TreeNode(45);
        TreeNode n1 = new TreeNode(66);
        TreeNode n2 = new TreeNode(66);
        TreeNode n3 = new TreeNode(66);
        TreeNode n4 = new TreeNode(66);

        tree.root = n45;
        n45.left = n1;
        n45.right = n2;

        n1.right = n3;
        n2.left = n4;
    }
}
