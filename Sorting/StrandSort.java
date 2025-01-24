/*
 * Strand Sort Algorithm in Java
 * Strand Sort works by finding the longest increasing subsequence in the input array and merging it.
 * This process continues iteratively to achieve a sorted list.
 */

 import java.util.*;

 public class StrandSort {
     public static List<Integer> strandSort(List<Integer> arr) {
         List<Integer> sortedList = new ArrayList<>();
         while (!arr.isEmpty()) {
             List<Integer> sublist = new ArrayList<>();
             int first = arr.remove(0);
             sublist.add(first);
 
             // Find the longest subsequence in increasing order
             Iterator<Integer> iter = arr.iterator();
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
 
     public static void main(String[] args) {
         List<Integer> arr = Arrays.asList(5, 2, 9, 1, 5, 6);
         List<Integer> sorted = strandSort(arr);
         System.out.println(sorted);
     }
 }
 
 /*
  * Time Complexity: O(n^2) in the worst case
  * Space Complexity: O(n) (not in-place sorting)
  */
 
