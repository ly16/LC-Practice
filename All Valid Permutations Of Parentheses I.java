/*
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Example:
N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
N = 0, all valid permutations are [""]

n is the number of pair
time = O(n)
space = O(2 ^ (2n)) without ignoring that half 


*/


public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    char[] cur = new char[n * 2]; // n is the number of pair
    helper(cur, n, n, 0, result);
    return result;
  }
  
  // left '(', right ')', index position to fill in
  private void helper(char[] cur, int left, int right, int index, List<String> result) {
    // terminate
    if (left == 0 && right == 0) {
       result.add(new String(cur)); // String
      return;
    }
    
    // we do not need remove, because we set the character at index 
    if(left > 0){
      cur[index] = '(';
      helper(cur, left - 1, right, index + 1, result);
    }
    
    if(left < right) {
      cur[index] = ')';
      helper(cur, left, right - 1, index + 1, result);
    }
  }
}
