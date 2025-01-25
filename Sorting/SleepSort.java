/*
 * Sleep Sort Algorithm in Java
 * Sleep Sort works by creating threads that sleep for a duration proportional to the value of each number.
 * The number is then printed when the thread "wakes up".
 * This algorithm is not practically used and is more of a novelty.
 */

 public class SleepSort {
    public static void sleepSort(int[] arr) throws InterruptedException {
        for (int num : arr) {
            new Thread(() -> {
                try {
                    Thread.sleep(num * 100); // Sleep for num milliseconds
                    System.out.print(num + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {5, 2, 9, 1, 5, 6};
        sleepSort(arr);
    }
}

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n) (requires additional space for threads)
 */

