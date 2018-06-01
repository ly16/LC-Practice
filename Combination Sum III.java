/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

time = O(n^2)
space = O(n)
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, result, new ArrayList<>());
        return result;
    }
    
    private void dfs(int k, int remain, int start, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k && remain == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(k, remain - i, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
