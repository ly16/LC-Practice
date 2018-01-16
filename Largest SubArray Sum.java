/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions
The given array is not null and has length of at least 1.

Examples
{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
{-2, -1, -3}, the largest subarray sum is -1

time = O(n)
space = O(1)
*/

public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here.
    // assume the given array is not null and has length of at least 1.
    int result = array[0];
    int cur = array[0];
    for (int i = 1; i < array.length; i++) {
      cur = Math.max(array[i], array[i] + cur);
      result = Math.max(cur, result);
    }
    return result;
  }
}
