/*
Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are NOT zero-based.

Example
Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)

time = O(2n) = O(n)
space = O(n) for hashmap
*/

public class Solution {
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];
        if (nums == null || nums.length <= 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           int sum = nums[i] + target;
           if (map.containsKey(sum)) {
               return builder(result, map, i, sum);
           }
            int diff = nums[i] - target;
            if (map.containsKey(diff)) {
                return builder(result, map, i, diff);
            }
            map.put(nums[i], i);
        }
        return result;
    }
    
    private int[] builder(int[] result, Map<Integer, Integer> map, int i, int match) {
        int index = map.get(match);
        int small = i < index ? i : index;
        int big = i < index ? index : i;
        result[0] = small + 1;
        result[1] = big + 1;
        return result;
    }
}
