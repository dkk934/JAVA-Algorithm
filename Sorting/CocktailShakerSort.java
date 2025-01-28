/*
 * Cocktail Shaker Sort Algorithm in Java
 * Cocktail Shaker Sort is an improvement over Bubble Sort that sorts in both directions, reducing the number of passes.
 */

 public class CocktailShakerSort {
    public static void cocktailShakerSort(int[] arr) {
        boolean swapped;
        int start = 0;
        int end = arr.length - 1;
        do {
            swapped = false;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            end--;
            for (int i = end; i > start; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }
            start++;
        } while (swapped);
    }

    public static void execute() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        cocktailShakerSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
 * Time Complexity: O(n²) in the worst case
 * Space Complexity: O(1) (in-place sorting)
 */
