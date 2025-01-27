public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        //  Loop through each element in the array
        for (int i = 0; i < n - 1; i++) {
            // Traverse the array, and compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // After each pass, the largest element is placed at the correct position
        }
    }

    public static void execute() {
        // Input array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // Print the original array
        System.out.println("Original Array:");
        for (int num : arr) System.out.print(num + " ");
        
        // Sort the array using Bubble Sort
        bubbleSort(arr);
        
        // Print the sorted array
        System.out.println("\nSorted Array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
