package dataStructures.nonlinearDataStructures;

public class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode(TreeNode treeNode) {
        this.data = treeNode.data;
    }
}
