/*
 * Strand Sort Algorithm in Java
 * Strand Sort works by finding the longest increasing subsequence in the input array and merging it.
 * This process continues iteratively to achieve a sorted list.
 */

 import java.util.*;

 public class StrandSort {
     public static List<Integer> strandSort(List<Integer> arr) {
         List<Integer> sortedList = new ArrayList<>();
         List<Integer> array = new ArrayList<>(arr);
         while (!array.isEmpty()) {
             List<Integer> sublist = new ArrayList<>();
             int first = array.remove(0);
             sublist.add(first);
 
             // Find the longest subsequence in increasing order
             Iterator<Integer> iter = array.iterator();
             while (iter.hasNext()) {
                 int num = iter.next();
                 if (num >= sublist.get(sublist.size() - 1)) {
                     sublist.add(num);
                     iter.remove();
                 }
             }
             sortedList.addAll(sublist);
         }
         return sortedList;
     }
 
     public static void execute() {
         List<Integer> arr = Arrays.asList(5, 2, 9, 1, 5, 6);
         System.out.println("Original Array:\n" + arr);
         List<Integer> sorted = strandSort(arr);
         System.out.println("Sorted Array:\n" + sorted);
     }
 }
 
 /*
  * Time Complexity: O(n^2) in the worst case
  * Space Complexity: O(n) (not in-place sorting)
  */
 
