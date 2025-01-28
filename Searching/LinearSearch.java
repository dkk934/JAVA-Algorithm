/*
 * Linear Search Algorithm in Java
 * Linear Search works by checking each element of the array sequentially.
 * It is the most basic searching algorithm with a time complexity of O(n).
 * It works well for unsorted arrays.
 */

public class LinearSearch {
    // Function to perform Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return the index if target is found
            }
        }
        return -1;  // Return -1 if target is not found
    }

    public static void execute() {
        int[] arr = {3, 5, 7, 2, 8, 6};
        int target = 7;
        int result = linearSearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

/*
 * Time Complexity: O(n) in the worst case (where n is the size of the array)
 * Space Complexity: O(1) (in-place search, no extra space needed)
 */
