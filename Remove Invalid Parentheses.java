/*
Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]

time = O(2^n)
space = O(n)
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        int[] count = getCount(s);
        dfs(s, 0, count[0], count[1], result);
        return result;
        
    }
    private void dfs(String s, int start, int left, int right, List<String> result) {
        // check current s and count, check left first and then right using isValid()
        if (left == 0 && right == 0 && isValid(s)) {
            result.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i == start || s.charAt(i) != s.charAt(i - 1)) {
                if (left > 0 && s.charAt(i) == '(') {
                    // start from i + 1 to the end, remove the ith char
                    dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, result);
                }
                if (right > 0 && s.charAt(i) == ')') {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, result);
                }
            }
        }
    }
    
    private int[] getCount(String s) {
        int[] count = new int[] {0, 0};
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count[0]++;
            }
            if (c == ')') {
                if (count[0] > 0) {
                    count[0]--;
                } else {
                    count[1]++;
                }
            }
        }
        return count;
    }
    
    private boolean isValid(String s) {
        int[] count = getCount(s);
        return count[0] == 0 && count[1] == 0;
    }
}
