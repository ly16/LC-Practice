/*
Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value do not keep any of them. 
Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. 
Return the array after deduplication.

Assumptions
The given array is not null

Examples
{1, 2, 2, 3, 3, 3} → {1}

time = O(n)
space = O(1)
*/

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int slow = 0;
    boolean repeat = false;
    for (int i = 1; i < array.length; i++) {
      if (array[slow] == array[i]) {
        repeat = true;
      } else if (repeat) {
        array[slow] = array[i];
        repeat = false;
      } else {
        array[++slow] = array[i];
      }
    }
    return Arrays.copyOf(array, repeat ? slow : slow + 1);
  }
}
