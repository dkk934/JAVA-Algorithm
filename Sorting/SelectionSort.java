public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Loop through the array
        for (int i = 0; i < n - 1; i++) {
            // Assume the current element is the minimum
            int minIdx = i;
            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j; // Update the index of the minimum element
                }
            }
            // Swap the minimum element with the first element of the unsorted part
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void execute() {
        // Input array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // Print the original array
        System.out.println("Original Array:");
        for (int num : arr) System.out.print(num + " ");
        
        // Sort the array using Selection Sort
        selectionSort(arr);
        
        // Print the sorted array
        System.out.println("\nSorted Array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
