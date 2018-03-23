/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific 
target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.
Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]

time = O(n) linear scan
space = O(1)
*/


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // time = O(n), space = O(1)
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
