/*
 * Pigeonhole Sort Algorithm in Java
 * Pigeonhole Sort works well when the range of input numbers is small.
 * It sorts elements by placing them in "pigeonholes" based on their value.
 */

 public class PigeonholeSort {
    public static void pigeonholeSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int range = max - min + 1;
        int[] holes = new int[range];

        for (int i = 0; i < arr.length; i++) {
            holes[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (holes[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        pigeonholeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
 * Time Complexity: O(n + range)
 * Space Complexity: O(n + range)
 */

