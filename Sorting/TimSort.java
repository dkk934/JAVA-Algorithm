/*
 * Tim Sort Algorithm in Java
 * Tim Sort is a hybrid of Merge Sort and Insertion Sort.
 * It is efficient for large datasets and is used in real-world applications.
 */

 import java.util.*;

 public class TimSort {
     public static void timSort(int[] arr) {
         Arrays.sort(arr);
     }
 
     public static void main(String[] args) {
         int[] arr = {5, 2, 9, 1, 5, 6};
         timSort(arr);
         for (int num : arr) {
             System.out.print(num + " ");
         }
     }
 }
 
 /*
  * Time Complexity: O(n log n) in all cases
  * Space Complexity: O(n) (not in-place sorting)
  */
 
