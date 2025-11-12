import java.util.Scanner;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree<T> {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Integer[] tree = {1, 2, 3, 4, 5, 6, 7, 8, null, null, 9, null, 10, null, null, null, null, null, 11};

        Tree<Integer> treeObj = new Tree<>();

        // Pass the index as a parameter
        BinaryTreeNode<Integer> root = treeObj.buildBinaryTree(tree, new int[]{-1});

        treeObj.preorderTraversal(root);

        sc.close();
    }

    // Modify buildBinaryTree to accept index as a parameter
    public BinaryTreeNode<T> buildBinaryTree(T[] arr, int[] idx) {
        idx[0]++; // Increment index

        // Check if idx exceeds the array length or the element is null
        if (idx[0] >= arr.length || arr[idx[0]] == null) {
            return null;
        }

        BinaryTreeNode<T> root = new BinaryTreeNode<>(arr[idx[0]]);

        // Recursively build the left and right subtrees
        root.left = buildBinaryTree(arr, idx);
        root.right = buildBinaryTree(arr, idx);

        return root;
    }

    // Preorder traversal: root -> left -> right
    public void preorderTraversal(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }

        // Print the data of the current BinaryTreeNode
        System.out.print(root.data + " ");

        // Traverse the left subtree
        preorderTraversal(root.left);

        // Traverse the right subtree
        preorderTraversal(root.right);
    }
}