/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions
There could be duplicate characters in the original set.

Examples
Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []


time = O(n!)
space = O(n)
*/


public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (set == null) {
    	return result;
    }
    StringBuilder sb = new StringBuilder();
    char[] charArray = set.toCharArray();
    Arrays.sort(charArray);
    helper(result, sb, charArray, 0);
    return result;
  } 
  private void helper(List<String> result, StringBuilder sb, char[] charArray, int index) {
  	result.add(sb.toString());
    for (int i = index; i < charArray.length; i++) {
    	if (i == index || charArray[i] != charArray[i - 1]) {
      	sb.append(charArray[i]);
        helper(result, sb, charArray, i + 1);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}


// leetcode version (duplicate)
// time = O(n^2), space = O(n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                list.add(nums[i]);
                dfs(result, nums, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
