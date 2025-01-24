/* 
 * Binary Search Algorithm in Java
 * Binary Search works on sorted arrays by dividing the array into two halves.
 * It compares the middle element with the target and continues searching in one half of the array.
 * It has a time complexity of O(log n).
 */

 public class BinarySearch {
    // Function to perform Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at the middle
            if (arr[mid] == target) {
                return mid;  // Return the index of the target
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        return -1;  // Return -1 if target is not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 8};
        int target = 7;
        int result = binarySearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
}

/*
 * Time Complexity: O(log n) where n is the size of the array
 * Space Complexity: O(1) (in-place search, no extra space needed)
 */

