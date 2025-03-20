/*
 * Strand Sort Algorithm in Java
 * Strand Sort works by finding the longest increasing subsequence in the input array and merging it.
 * This process continues iteratively to achieve a sorted list.
 */

 import java.util.*;

 public class StrandSort {

     public static List<Integer> merge(List<Integer> sortedList, List<Integer> sublist){
         List<Integer> mergedList = new ArrayList<>();
         int i = 0, j = 0;
         // Merge the two lists
         while (i < sortedList.size() && j < sublist.size()) {
             if (sortedList.get(i) < sublist.get(j)) {
                 mergedList.add(sortedList.get(i));
                 i++;
             } else {
                 mergedList.add(sublist.get(j));
                 j++;
             }
         }
         // Add the remaining elements
         mergedList.addAll(sortedList.subList(i, sortedList.size()));
         mergedList.addAll(sublist.subList(j, sublist.size()));
         return mergedList;
     }

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
             // Merge subsequence into sorted list
             sortedList = merge(sortedList, sublist);
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
 
