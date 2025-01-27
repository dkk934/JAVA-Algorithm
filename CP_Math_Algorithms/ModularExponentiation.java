// Java program for Modular Exponentiation (x^y % p)

public class ModularExponentiation {
    // Function to perform (x^y) % p
    public static int modExp(int x, int y, int p) {
        int res = 1;
        x = x % p; // In case x is larger than p

        // Perform exponentiation by squaring
        while (y > 0) {
            // If y is odd, multiply the result by x
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            // Square x and reduce y
            x = (x * x) % p;
            y >>= 1; // y = y / 2
        }

        return res;
    }

    public static void execute() {
        int x = 3, y = 13, p = 1000000007;
        System.out.println("Result of (" + x + "^" + y + " % " + p + ") = " + modExp(x, y, p));
    }
}

/*
 * Time Complexity:
 * - O(log y), as we are halving y at each step.
 * 
 * Space Complexity:
 * - O(1), only a few integer variables are used.
 */

