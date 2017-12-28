/*
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Example:
N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
N = 0, all valid permutations are [""]

n is the number of pair
time = O(2^(2n))
space = O(2n) without ignoring that half 


*/

public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    char[] cur = new char[2 * n];
    helper(result, cur, 0, n, n);
    return result;
  }
  public void helper(List<String> result, char[] cur, int index, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(new String(cur));
      return;
    }
    
    if (left > 0) {
      cur[index] = '(';
      helper(result, cur, index + 1, left - 1, right);
    }
    if (right > left) {
      cur[index] = ')';
      helper(result, cur, index + 1, left, right - 1);
    }
  }
}
