/*
 * Flash Sort Algorithm in Java
 * Flash Sort is based on the concept of classification and performs well when data is uniformly distributed.
 * The algorithm first divides the data into "buckets" and then sorts within the buckets.
 */

 public class FlashSort {
    // Flash Sort algorithm
    public static void flashSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        int min = arr[0], max = arr[0];
        // Find the min and max elements in the array
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int m = (int) (0.45 * n); // Number of buckets
        int[] l = new int[m]; // Bucket array
        for (int i = 0; i < n; i++) {
            int index = (int) ((double) (arr[i] - min) / (max - min) * (m - 1));
            l[index]++;
        }

        for (int i = 1; i < m; i++) {
            l[i] += l[i - 1];
        }

        int[] temp = new int[n];
        System.arraycopy(arr, 0, temp, 0, n);
        for (int i = n - 1; i >= 0; i--) {
            int index = (int) ((arr[i] - min) / (max - min) * (m - 1));
            temp[--l[index]] = arr[i];
        }

        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        flashSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

/*
 * Time Complexity: O(n) in the best case, O(n^2) in the worst case
 * Space Complexity: O(n) (not in-place sorting)
 */

