// Java program to find modular inverse using Extended Euclidean Algorithm

public class ModularInverse {
    // Function to find GCD and coefficients using Extended Euclidean Algorithm
    public static int extendedGcd(int a, int b) {
        if (b == 0) {
            return a; // GCD is a when b is 0
        }
        return extendedGcd(b, a % b); // Recursive call
    }

    // Function to find modular inverse of a modulo m
    public static int modInverse(int a, int m) {
        int g = extendedGcd(a, m);
        if (g != 1) {
            // Modular inverse doesn't exist if GCD is not 1
            return -1;
        }
        return (extendedGcd(a, m) + m) % m; // Modular inverse exists
    }

    public static void main(String[] args) {
        int a = 3, m = 11;
        int inverse = modInverse(a, m);
        if (inverse == -1) {
            System.out.println("Inverse doesn't exist.");
        } else {
            System.out.println("Modular inverse of " + a + " modulo " + m + " is: " + inverse);
        }
    }
}

/*
 * Time Complexity:
 * - O(log m), where m is the modulus.
 * 
 * Space Complexity:
 * - O(1), only a few integer variables are used.
 */

