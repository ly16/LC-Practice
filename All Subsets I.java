/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.
Assump:
There are no duplicate characters in the original set.


Examples
Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []


time = O(2^n), n is the number of element
space = O(height) = O(n)
*/

public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    char[] setArray = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(result, setArray, 0, sb);
    return result;
  }
  public void helper(List<String> result, char[] setArray, int index, StringBuilder sb) {
    if (index == setArray.length) {
      result.add(sb.toString());
      return;
    }
    helper(result, setArray, index + 1, sb);
    helper(result, setArray, index + 1, sb.append(setArray[index]));
    sb.deleteCharAt(sb.length() - 1);
  }
}



// leetcode version
// time = O(2^n)
// space = O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> level, int index) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(level));
            return;
        }
        
        // not add
        helper(nums, result, level, index + 1);
        // add and remove
        level.add(nums[index]);
        helper(nums, result, level, index + 1);
        level.remove(level.size() - 1);
    }
}


// time = O(n!)
// space = O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
            list.add(nums[i]);
            dfs(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }    
}
