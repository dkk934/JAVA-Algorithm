// Node class representing a single node in the BST
class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int item) {
        data = item;
        left = right = null;
    }
}

// Binary Search Tree class with various operations
public class BinarySearchTree {
    BSTNode root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a node into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive method to insert a new key
    private BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive method for searching a key
    private boolean searchRec(BSTNode root, int key) {
        if (root == null) {
            return false; // Key not found
        }
        if (key == root.data) {
            return true; // Key found
        }
        return key < root.data ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // In-order Traversal (Left, Root, Right)
    public void inOrder() {
        System.out.print("In-order Traversal: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Delete a key from the BST
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive method for deleting a node
    private BSTNode deleteRec(BSTNode root, int key) {
        if (root == null) {
            return root;
        }

        // Traverse the tree to find the node to delete
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    // Find the minimum value in a subtree
    private int minValue(BSTNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Main method to test the BST implementation
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Display the tree using in-order traversal
        bst.inOrder();

        // Search for a key
        int keyToSearch = 40;
        System.out.println("Is " + keyToSearch + " present in the BST? " + bst.search(keyToSearch));

        // Delete a key
        int keyToDelete = 70;
        System.out.println("Deleting " + keyToDelete + " from the BST.");
        bst.delete(keyToDelete);

        // Display the tree after deletion
        bst.inOrder();
    }
}
