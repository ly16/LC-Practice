/*
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10

time = O(logn)
space = O(1)
*/

public class Solution {
    public int mountainSequence(int[] nums) {
        // first/last occurance
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // compare with neighbors
            if (nums[mid] >= nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return Math.max(nums[left], nums[right]);
    }
}
