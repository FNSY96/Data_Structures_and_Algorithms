package dataStructures.nonlinearDataStructures;

public class BST {

    BinaryTreeNode insert(BinaryTreeNode root, int data) {

        /* If the tree is empty, return a new node */
        if (root == null) return new BinaryTreeNode(data);


        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);
        return root;
    }

    public BinaryTreeNode delete(BinaryTreeNode root, int data) {
        /* Base Case: If the tree is empty */
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);

            // if data is same as root's data, then This is the node 
            // to be deleted 
        else {
            // node with only one child or no child 
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.data = minValue(root.right);

            // Delete the inorder successor 
            root.right = delete(root.right, root.data);
        }

        return root;
    }


    public int minValue(BinaryTreeNode root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public BinaryTreeNode search(BinaryTreeNode root, int data) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == data)
            return root;

        // val is greater than root's key
        if (root.data > data)
            return search(root.left, data);

        // val is less than root's key
        return search(root.right, data);
    }

}
