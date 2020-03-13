package dataStructures.nonlinearDataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertTreeToBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = buildTree();
        BinaryTreeNode binaryTree = ConvertTreeToBinaryTree.makeBinaryTree(buildTree());
        TreeTraversals.preOrder(binaryTree);

    }

    public static void print(TreeNode t) {
        if (t == null) return;

        System.out.println((char)t.data);
        if (t.children == null) return;
        for (TreeNode c : t.children) {
            print(c);
        }
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode('A');
        ArrayList<TreeNode> lvl1 = new ArrayList<>();
        lvl1.add(new TreeNode('B'));
        lvl1.add(new TreeNode('C'));
        lvl1.add(new TreeNode('D'));
        root.children = lvl1;


        ArrayList<TreeNode> lvl2 = new ArrayList<>();
        lvl2.add(new TreeNode('E'));
        lvl2.add(new TreeNode('F'));
        lvl2.add(new TreeNode('I'));
        lvl1.get(0).children = lvl2;

        ArrayList<TreeNode> lvl3 = new ArrayList<>();
        lvl3.add(new TreeNode('J'));
        lvl3.add(new TreeNode('G'));
        lvl1.get(1).children = lvl3;

        lvl1.get(2).children = new ArrayList<>();
        lvl1.get(2).children.add(new TreeNode('H'));

        ArrayList<TreeNode> lvl4 = new ArrayList<>();
        lvl4.add(new TreeNode('K'));
        lvl4.add(new TreeNode('L'));
        lvl4.add(new TreeNode('M'));
        lvl1.get(2).children.get(0).children = lvl4;

        return root;
    }

    public static BinaryTreeNode makeBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.children == null) return new BinaryTreeNode(root);

        BinaryTreeNode bRoot = new BinaryTreeNode(root);
        bRoot.left = makeBinaryTree(root.children.get(0));
        BinaryTreeNode current = bRoot.left;

        for (int i = 1; i < root.children.size(); i++) {
            current.right = makeBinaryTree(root.children.get(i));
            current = current.right;
        }


        return bRoot;
    }

}
