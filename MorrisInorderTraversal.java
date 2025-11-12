import java.util.ArrayList;

public class MorrisInorderTraversal {

    public static ArrayList<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> list = new ArrayList<>();
        BinaryTreeNode<Integer> current = root;

        while (current != null) {
            if (current.left == null) {
                // If no left child, visit the current node and move right
                list.add(current.data);
                current = current.right;
            } else {
                // Find the inorder predecessor (rightmost node of the left subtree)
                BinaryTreeNode<Integer> predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make current the right child of its inorder predecessor
                    predecessor.right = current;
                    current = current.left; // Move to left subtree
                } else {
                    // Restore the tree structure by removing the thread
                    predecessor.right = null;
                    list.add(current.data); // Visit the node
                    current = current.right; // Move to right subtree
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[] nodes = {1, 2, null, null, 3, 4, null, null, 5, null, null};

        Tree<Integer> treeObj = new Tree<>();
        BinaryTreeNode<Integer> root = treeObj.buildBinaryTree(nodes, new int[]{-1});

        ArrayList<Integer> list = inorderTraversal(root);

        for (int val : list) {
            System.out.println(val);
        }
    }
}