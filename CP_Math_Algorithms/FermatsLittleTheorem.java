// Java program to check if a number is prime using Fermat's Little Theorem

public class FermatsLittleTheorem {
    // Function to check if n is prime using Fermat's Little Theorem
    public static boolean isPrime(int n) {
        // If n is less than 2, it's not prime
        if (n <= 1) {
            return false;
        }
        // Choose a random a where 2 <= a < n-1
        int a = 2;
        // Fermat's Little Theorem states that a^(n-1) % n should be 1 if n is prime
        return modExp(a, n - 1, n) == 1;
    }

    // Function to perform modular exponentiation
    public static int modExp(int x, int y, int p) {
        int res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
            y >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 11;
        if (isPrime(n)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}

/*
 * Time Complexity:
 * - O(log n), as the modular exponentiation takes log n time.
 * 
 * Space Complexity:
 * - O(1), only a few integer variables are used.
 */

