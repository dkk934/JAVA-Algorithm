// Java program to implement Sieve of Eratosthenes

import java.util.*;

public class SieveOfEratosthenes {
    // Function to find all prime numbers up to n
    public static void sieve(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // Assume all numbers are prime initially
        primes[0] = primes[1] = false; // 0 and 1 are not prime

        // Check for all numbers from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println("Prime numbers up to " + n + ":");
        sieve(n);
    }
}

/*
 * Time Complexity:
 * - O(n log log n), where n is the input number. This is the time taken to mark all non-prime numbers.
 * 
 * Space Complexity:
 * - O(n) for storing the boolean array that keeps track of prime numbers.
 */

    

