// Java program to implement Binary Indexed Tree (Fenwick Tree)
public class BinaryIndexedTree {
    private int[] BIT;
    private int n;

    // Constructor to initialize the BIT array
    public BinaryIndexedTree(int n) {
        this.n = n;
        BIT = new int[n + 1];
    }

    // Update BIT with a given value
    public void update(int index, int value) {
        while (index <= n) {
            BIT[index] += value;
            index += (index & -index); // Move to the next index
        }
    }

    // Query the sum from 1 to the given index
    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= (index & -index); // Move to the parent index
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryIndexedTree BIT = new BinaryIndexedTree(5);

        // Update the BIT with values at different indices
        BIT.update(1, 1);
        BIT.update(2, 2);
        BIT.update(3, 3);

        // Query the sum from 1 to 3
        System.out.println("Sum of first 3 elements: " + BIT.query(3));
    }

}

/*
 * Time Complexity:
 * - O(log n) for both update and query operations.
 * 
 * Space Complexity:
 * - O(n), as we maintain the BIT array.
 */

