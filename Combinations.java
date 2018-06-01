/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

time = O(n!)
space = O(n)
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(result, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
