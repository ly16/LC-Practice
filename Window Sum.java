/*
Given an array of n integer, and a moving window(size k),
move the window at each iteration from the start of the array, 
find the sum of the element inside the window at each moving.

Example
For array [1,2,7,8,5], moving window size k = 3. 
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]

time = O(n)
space = O(n + k -1) additional space for the new int[] array
*/

public class Solution {
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < k || k < 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            result[0] += nums[i];
        }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        return result;
    }
}
