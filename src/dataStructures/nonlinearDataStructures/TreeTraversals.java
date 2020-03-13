package dataStructures.nonlinearDataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {

    public static void main(String[] args) {
        BinaryTreeNode root = TreeTraversals.buildTree();
        TreeTraversals.postOrder(root);
//        TreeTraversals.breadthFirstSearch(root);

    }

    public static void preOrder(BinaryTreeNode root) {
        if (root == null) return;

        System.out.print((char)root.data); //visit current
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinaryTreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print((char)root.data); //visit current
        inOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print((char)root.data); //visit current

    }

    public static void breadthFirstSearch(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode visitingNode = queue.poll();
            if(visitingNode == null) continue;
            System.out.println((char)visitingNode.data);
            queue.add(visitingNode.left);
            queue.add(visitingNode.right);
        }
    }

    private static BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode('A');
        root.left = new BinaryTreeNode('B');
        root.left.left = new BinaryTreeNode('C');
        root.left.right = new BinaryTreeNode('D');
        root.left.left.left = new BinaryTreeNode('E');
        root.left.left.right = new BinaryTreeNode('F');
        root.left.left.right.left = new BinaryTreeNode('I');
        root.left.left.right.right = new BinaryTreeNode('H');
        root.left.right.right = new BinaryTreeNode('G');
        return root;
    }


}
