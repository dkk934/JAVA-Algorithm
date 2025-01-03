import java.util.Arrays;

public class CountingSort {
    // Counting sort implementation
    public static void countingSort(int[] array) {
        // Find the maximum value in the array
        int max = Arrays.stream(array).max().orElse(0);
        int min = Arrays.stream(array).min().orElse(0);
        int range = max - min + 1;

        // Create a count array and initialize it to 0
        int[] count = new int[range];
        int[] output = new int[array.length];

        // Count the occurrences of each element
        for (int num : array) {
            count[num - min]++;
        }

        // Update the count array with cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copy the sorted values back into the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original array: " + Arrays.toString(array));

        countingSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
