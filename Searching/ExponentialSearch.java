/*
 * Exponential Search Algorithm in Java
 * Exponential Search works by first finding a range where the element might exist using exponential steps.
 * After that, it performs a binary search within that range to find the target.
 */

public class ExponentialSearch {
    // Function to perform Exponential Search
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // If target is at index 0
        if (arr[0] == target) {
            return 0;
        }

        // Find range for binary search
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;  // Double the range
        }

        // Perform Binary Search in the range found
        return binarySearch(arr, target, i / 2, Math.min(i, n - 1));
    }

    // Binary Search function used within Exponential Search
    public static int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Return the index if target is found
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Return -1 if target is not found
    }

    public static void execute() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = exponentialSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

/*
 * Time Complexity: O(log n)
 * Space Complexity: O(1) (in-place search, no extra space needed)
 */
