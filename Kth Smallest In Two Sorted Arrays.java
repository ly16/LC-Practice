/*
Given two sorted arrays of integers, find the Kth smallest number.

Assumptions
The two given arrays are not null and at least one of them is not empty
K >= 1, K <= total lengths of the two sorted arrays

Examples
A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.


time = O(logk)
space = O(logk)
*/

public class Solution {
  public int kth(int[] a, int[] b, int k) {
    // Write your solution here
    return helper(a, 0, b, 0, k);	
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
		int bmid = bleft + k / 2 -  1 >= b.length ? Integer.MAX_VALUE : b[bleft + k / 2 - 1];

		if (amid < bmid) {
			return helper(a, aleft + k / 2, b, bleft, k - k / 2);
		} else {
			return helper(a, aleft, b, bleft + k / 2, k - k / 2);
		}
	}
}
