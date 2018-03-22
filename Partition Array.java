/*
Given an array nums of integers and an int k, 
partition the array (i.e move the elements in "nums") such that:
All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Example
If nums = [3,2,2,1] and k = 2, a valid answer is 1
if nums = [] k = 9, return 0
if nums = [1,2,3] k = 10, return 4

time = O(n)
space = O(1)
*/

public class Solution {
    public int partitionArray(int[] nums, int k) {
        // time = O(n), space = O(1)
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }
}
