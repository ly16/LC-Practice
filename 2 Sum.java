/*
Determine if there exist two elements in a given array, the sum of which is the given target number.

Assumptions
The given array is not null and has length of at least 2

Examples
A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
A = {2, 4, 1}, target = 4, return false

time = O(n)
space = O(n)
*/



// lintcode version
public class Solution {
  public boolean existSum(int[] array, int target) {
    // Write your solution here
    Set<Integer> set = new HashSet<>();
    for (int num : array) {
    	if (set.contains(target - num)) {
      	return true;
      }
      set.add(num);
    }
    return false;
  }
}


// leetcode version
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
