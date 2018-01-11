/*
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions
The given array is not null

Examples
{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.

time = O(n)
space = O(1)
*/


public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
      return 0;
    }
    int result = 1;
    int cur = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        cur++;
        result = Math.max(cur, result);
      } else {
        cur = 1;
      }
    }
    return result;
  }
}
