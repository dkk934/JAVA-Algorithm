import java.util.Arrays;

public class RadixSort {
    // Get the maximum value in the array
    public static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Perform counting sort based on a specific digit
    public static void countingSort(int[] array, int place) {
        int size = array.length;
        int[] output = new int[size];
        int[] count = new int[10];

        // Count the occurrences of each digit at the current place value
        for (int num : array) {
            int digit = (num / place) % 10;
            count[digit]++;
        }

        // Update the count array to store actual positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = size - 1; i >= 0; i--) {
            int digit = (array[i] / place) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the sorted values back to the original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    // Radix Sort implementation
    public static void radixSort(int[] array) {
        int max = getMax(array);

        // Sort the array by each digit's place value (1s, 10s, 100s, etc.)
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(array, place);
        }
    }

    // Main method to test the implementation
    public static void execute() {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(array));

        radixSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
