/*
Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

Assumptions
A is not null

Examples
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because [2, 3, 4, 5] is the longest ascending subsequence.

time = O(nlogn)
space = O(n)  for the int[]
*/

public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    if (array.length == 0) {
    	return 0;
    }
    int result = 1;
    int[] longest = new int[array.length + 1];
    longest[1] = array[0];
    for (int i = 1; i < array.length; i++) {
    	int index = find(longest, 1, result, array[i]);
      if (index == result) {
      	longest[++result] = array[i];
      } else {
      	longest[index + 1] = array[i];
      }
    }
    return result;
  }
  
  private int find(int[] longest, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
    	if (longest[mid] >= target) {
      	right = mid - 1;
      } else {
      	left = mid + 1;
      }
    }
    return right;
  }
}
