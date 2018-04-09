/*
Given a list of numbers, return all possible permutations.

Example
For nums = [1,2,3], the permutations are:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

time = O(n!)
space = O(n)
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, 
                    boolean[] visited, 
                    List<Integer> curList,  
                    List<List<Integer>> result) {
                        
        if (nums.length == curList.size()) {
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            curList.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, curList, result);
            visited[i] = false;
            curList.remove(curList.size() - 1);
        }
    }
}

