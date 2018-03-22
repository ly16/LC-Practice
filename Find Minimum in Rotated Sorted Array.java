/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.

Example
Given [4, 5, 6, 7, 0, 1, 2] return 0

time = O(logn)
space = O(1)
*/

public class Solution {
    public int findMin(int[] nums) {
        // time = O(logn), space = O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // from pivot to the right is ascending
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
