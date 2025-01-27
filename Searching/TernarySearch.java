/*
 * Ternary Search Algorithm in Java
 * Ternary Search divides the search space into three parts and checks if the target lies in one of them.
 * It is more efficient than Linear Search but less efficient than Binary Search in terms of comparisons.
 */

 public class TernarySearch {
    // Function to perform Ternary Search
    public static int ternarySearch(int[] arr, int left, int right, int target) {
        if (right >= left) {
            // Divide the array into three parts
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            // Check if target is at mid1 or mid2
            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }

            // Search in one of the three parts
            if (target < arr[mid1]) {
                return ternarySearch(arr, left, mid1 - 1, target);
            } else if (target > arr[mid2]) {
                return ternarySearch(arr, mid2 + 1, right, target);
            } else {
                return ternarySearch(arr, mid1 + 1, mid2 - 1, target);
            }
        }
        return -1;  // Return -1 if target is not found
    }

    public static void execute() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = ternarySearch(arr, 0, arr.length - 1, target);
        System.out.println("Element found at index: " + result);
    }
}

/*
 * Time Complexity: O(log3 n), or O(log n / log 3)
 * Space Complexity: O(1) (in-place search, no extra space needed)
 */

