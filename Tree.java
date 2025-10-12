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
    private int idx = -1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Integer[] tree = {1, 2, 3, 4, 5, 6, 7, 8, null, null, 9, null, 10, null, null, null, null, null, 11};

        Tree<Integer> treeObj = new Tree<>();

        BinaryTreeNode<Integer> root = treeObj.buildBinaryTree(tree);

        treeObj.preorderTraversal(root);

        sc.close();
    }

    public BinaryTreeNode<T> buildBinaryTree(T[] arr) {
        idx++;

        // Check if idx exceeds the array length
        if (idx >= arr.length || arr[idx] == null) {
            return null;
        }

        BinaryTreeNode<T> root = new BinaryTreeNode<>(arr[idx]);

        // Recursively build the left and right subtrees
        root.left = buildBinaryTree(arr);
        root.right = buildBinaryTree(arr);

        return root;
    }

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