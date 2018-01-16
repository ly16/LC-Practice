/*
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions
The given array is not null

Examples
{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.

time = O(n)
space = O(1)
*/

public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    // array is not null
    int result = 0;
    int cur = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 1) {
        if (i == 0 || array[i - 1] == 0) {
          cur = 1;
        } else {
          cur++;
        }
        result = Math.max(cur, result);
      }
    }
    return result;
  }
}
