/*
 * Shell Sort Algorithm in Java
 * Shell Sort is an optimization of Insertion Sort that reduces the number of swaps by considering elements far apart.
 */

 public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void execute() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        shellSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
 * Time Complexity: O(n log n) to O(n^2) depending on gap sequence
 * Space Complexity: O(1) (in-place sorting)
 */

