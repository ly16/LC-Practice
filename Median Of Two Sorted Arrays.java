/*
Given two sorted arrays of integers in ascending order, find the median value.

Assumptions
The two given array are not null and at least one of them is not empty
The two given array are guaranteed to be sorted

Examples
A = {1, 4, 6}, B = {2, 3}, median is 3
A = {1, 4}, B = {2, 3}, median is 2.5

time = O(log(a+b))
space = O(log(a+b))
*/

public class Solution {
  public double median(int[] a, int[] b) {
    // Write your solution here
    int m = (a.length + b.length + 1) / 2;
    int n = (a.length + b.length + 2) / 2;
    return (helper(a, 0, b, 0, m) + helper(a, 0, b, 0, n)) / 2.0;
  }
  
  private int helper(int[] a, int aleft, int[] b, int bleft, int k) {
  	if (aleft >= a.length) {
    	return b[bleft + k - 1];
    }
    if (bleft >= b.length) {
    	return a[aleft + k - 1];
    }
    if (k == 1) {
    	return Math.min(a[aleft], b[bleft]);
    }
    int amid = aleft + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[aleft + k / 2 - 1];
    int bmid = bleft + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[bleft + k / 2 - 1];
    if (amid < bmid) {
    	return helper(a, aleft + k / 2, b, bleft, k - k / 2);
    } else {
    	return helper(a, aleft, b, bleft + k / 2, k - k / 2);
    }
  }
}
