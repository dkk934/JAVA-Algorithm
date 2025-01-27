/*
 * Jump Search Algorithm in Java
 * Jump Search divides the array into blocks of fixed size and performs a linear search within the block.
 * It is an improvement over Linear Search for sorted arrays.
 * It has a time complexity of O(√n), which is better than O(n) for large arrays.
 */

 public class JumpSearch {
    // Function to perform Jump Search
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);  // Block size to jump

        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1;  // Element not found
            }
        }

        // Perform linear search within the block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i;  // Return the index if target is found
            }
        }

        return -1;  // Return -1 if target is not found
    }

    public static void execute() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = jumpSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

/*
 * Time Complexity: O(√n) where n is the size of the array
 * Space Complexity: O(1) (in-place search, no extra space needed)
 */

