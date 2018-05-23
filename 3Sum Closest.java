/*
Given an array nums of n integers and an integer target, 
find three integers in nums such that the sum is closest to target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

1 2 3 4 5
i l     r

time = O(n^2 + nlogn) = O(n^2)
space = O(1)
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == target) {
                    return tmp;
                } else if (tmp < target) {
                    left++;
                    closest = Math.abs(closest - target) > Math.abs(tmp - target) ? tmp : closest;
                } else {
                    right--;
                    closest = Math.abs(closest - target) > Math.abs(tmp - target) ? tmp : closest;
                }
            }
        }
        return closest;
    }
}

