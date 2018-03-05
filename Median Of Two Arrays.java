/*
Given two arrays of integers, find the median value.

Assumptions
The two given array are not null and at least one of them is not empty
The two given array are not guaranteed to be sorted

Examples
A = {4, 1, 6}, B = {2, 3}, median is 3
A = {1, 4}, B = {3, 2}, median is 2.5

time = O(aloga + blogb + log(a+b))
space = O(log(a+b))
*/

public class Solution {
  public double median(int[] a, int[] b) {
    // Write your solution here
    int total = a.length + b.length;
    Arrays.sort(a);
    Arrays.sort(b);
    if (total % 2 == 0) {
    	return (helper(a, 0, b, 0, total / 2 ) + helper(a, 0, b, 0, total / 2 + 1)) / 2.0;
    } else {
    	return helper(a, 0, b, 0, total / 2 + 1);
    }
  }
  
   private int helper (int[] a, int aleft, int[] b, int bleft, int k) {
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
 			return helper(a, aleft + k / 2 , b, bleft, k - k / 2);
 		} else {
 			return helper(a, aleft, b, bleft + k / 2, k - k / 2 );
 		}
 	} 
}
