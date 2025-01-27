import java.util.LinkedList;
import java.util.Queue;

// Binary Tree class with various operations
public class BinaryTree {
    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // In-order Traversal (Left, Root, Right)
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // Pre-order Traversal (Root, Left, Right)
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Post-order Traversal (Left, Right, Root)
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Insert a node in the binary tree (level order)
    void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        // Use a queue to find the first empty position in level order
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    // Calculate the height of the binary tree
    int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Main method to test the Binary Tree implementation
    public static void execute() {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        // Perform traversals
        System.out.println("In-order Traversal:");
        tree.inOrder(tree.root);

        System.out.println("\nPre-order Traversal:");
        tree.preOrder(tree.root);

        System.out.println("\nPost-order Traversal:");
        tree.postOrder(tree.root);

        // Calculate the height of the tree
        System.out.println("\nHeight of the tree: " + tree.height(tree.root));
    }

    // Node class representing a single node in the binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
