/*
Given an integer array nums, find the contiguous subarray within an array 
(containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

time = O(n)
space = O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int r = nums[0];
        int imax = r, imin = r;
        for (int i = 1; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            r = Math.max(r, imax);
        }
        return r;
    } 
}
