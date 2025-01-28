// Java program to implement Euclidean Algorithm for GCD

public class EuclideanAlgorithm {
    // Function to compute GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        // Base case: if b becomes 0, the GCD is a
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void execute() {
        int a = 56, b = 98;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}

/*
 * Time Complexity:
 * - O(log(min(a, b))) where a and b are the two numbers.
 * 
 * Space Complexity:
 * - O(1), as we are using only a few variables.
 */
