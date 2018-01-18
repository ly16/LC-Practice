/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, 
from left to right. For each group of elements with the same value do not keep any of them.
Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions
The given array is not null

Examples
{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}

time = O(n)
space = O(1)
*/

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return array;
    }
    int slow = -1;
    for (int i = 0; i < array.length; i++) {
      if (slow == -1 || array[i] != array[slow]) {
        array[++slow] = array[i];
      } else {
        while (i + 1 < array.length && array[i + 1] == array[slow]) {
          i++;
        }
        slow--;
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
