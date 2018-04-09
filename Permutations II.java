/*
Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
For numbers [1,2,2] the unique permutations are:
[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]

time = O(n! + nlogn) = O(n!)
space = O(n)
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        // avoid duplication
        Arrays.sort(nums);
        bfs(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }
    
    private void bfs(int[] nums, 
                    List<List<Integer>> result,
                    ArrayList<Integer> curLayer, 
                    boolean[] visited) {
        if (curLayer.size() == nums.length) {
            result.add(new ArrayList<Integer>(curLayer));
            return;
        }
                   
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            // from the first repeated to the end
            // ab1b2 but not ab2b1
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            curLayer.add(nums[i]);
            visited[i] = true;
            bfs(nums, result, curLayer, visited);
            visited[i] = false;
            curLayer.remove(curLayer.size() - 1);
        }    
                     }
};
