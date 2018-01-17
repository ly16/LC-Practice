/*
Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value keep at most two of them. 
Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. 
Return the array after deduplication.

Assumptions
The given array is not null

Examples
{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}

time = O(n)
space = O(1)
*/

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 2) {
      return array;
    }
    int slow = 2;
    int fast = 2;
    while (fast < array.length) {
      if (array[fast] != array[slow - 2]) {
        array[slow++] = array[fast++];
      } else {
        fast++;
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
