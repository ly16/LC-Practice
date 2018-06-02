/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

time = O(mn)
space = O(mn) for the matrix
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    
    private boolean isMatchHelper(String s, int sIndex,
                                  String p, int pIndex,
                                  boolean[][] memo,
                                  boolean[][] visited) {
        // "" == ""
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        
        if (sIndex == s.length()) {
            return isEmpty(p, pIndex);
        }
        
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        
        // consider a* as a bundle
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited) ||
                charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        } else {
            match = charMatch(sChar, pChar) && 
                isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }
        
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    
    private boolean charMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }
    
    private boolean isEmpty(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i += 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
