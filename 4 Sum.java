/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions
The given array is not null and has length of at least 4

Examples
A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
A = {1, 2, 2, 3, 4}, target = 12, return false

1 2 2 3 4
j i
    j   i  

time = O(n^2)
space = O(n) for a hashmap
*/


public class Solution {
  static class Pair {
  	int left;
    int right;
    Pair(int left, int right){
    	this.left = left;
      this.right = right;
    }
  }
  public boolean exist(int[] array, int target) {
    // Write your solution here
    Map<Integer, Pair> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
    	for (int j = 0; j < i; j++) {
      	int pairSum = array[j] + array[i];
        // no overlap, avoid duplicated results
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
        	return true;
        } 
        if (!map.containsKey(pairSum)) {
        	map.put(pairSum, new Pair(j, i));
        }
      }
    }
    return false;
  }
}


/*
leetcode version
time = O(n^3)
space = O(1)
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // O(n^3) version
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
                    			continue;
                		}   
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
                        			result.add(Arrays.asList(nums[i], nums[j], nums[left++],nums[right--]));
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return result;
    	}
}
