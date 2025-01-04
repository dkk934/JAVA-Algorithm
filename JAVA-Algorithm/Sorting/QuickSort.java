public class QuickSort {
    // Partition method to rearrange elements
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the rightmost element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partition index
    }

    // Recursive Quick Sort method
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(array, low, high);

            // Recursively sort the subarrays
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
