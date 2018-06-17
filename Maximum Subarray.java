/*
Given an array of integers, find a contiguous subarray which has the largest sum.
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

time = O(n)
space = O(n) for the array in version 1
space = O(1) in version 2
*/


// method1: preFix version
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE, min = 0, preFix = 0;
        
        for (int i = 0; i < nums.length; i++) {
            preFix += nums[i];
            max = Math.max(max, preFix - min);
            min = Math.min(min, preFix);
        }
        return max;
    }
}


// method2: dp
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int cur = nums[0];
        int result = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            result = Math.max(cur, result);
        }
        return result;
    }
}
