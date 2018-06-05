/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]


time = O(n!)
space = O(n)
*/

class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] result = new int[]{0};
        dfs(new ArrayList<>(), result, n);
        return result[0];
    }
    
    private void dfs(List<Integer> cols, int[] result, int n) {
        if (cols.size() == n) {
            result[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(cols, i)) {
                cols.add(i);
                dfs(cols, result, n);
                cols.remove(cols.size() - 1);
            }
        }
    }
    
    private boolean valid(List<Integer> cols, int col) {
        int rows = cols.size();
        for (int i = 0; i < rows; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (Math.abs(cols.get(i) - col) == rows - i) {
                return false;
            }
        }
        return true;
    }
}
