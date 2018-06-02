/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input:
s = "acdcb"
p = "a*c?b"
Output: false


time = O(nm)
space = O(mn) for the matrix
*/

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] record = new boolean[s.length()][p.length()];
        return match(s, 0, p, 0, record, visited);
    }
    
    private boolean match(String s, int sIndex, String p, int pIndex, boolean[][] record, boolean[][] visited) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }
        if (visited[sIndex][pIndex]) {
            return record[sIndex][pIndex];
        }
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean deter;
        
        if (pChar == '*') {
            deter = match(s, sIndex, p, pIndex + 1, record, visited) || match(s, sIndex + 1, p, pIndex, record, visited);
        } else {
            deter = charMatch(sChar, pChar) && match(s, sIndex + 1, p, pIndex + 1, record, visited);
        }
        visited[sIndex][pIndex] = true;
        record[sIndex][pIndex] = deter;
        return deter;
    }
    
    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    
    private boolean charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }
}
