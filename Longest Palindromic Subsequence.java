/*
Given a string s, find the longest palindromic subsequence's length in s. 
You may assume that the maximum length of s is 1000.

Example
Given s = "bbbab" return 4
One possible longest palindromic subsequence is "bbbb".

2-d dp
time = O(n^2)
space = O(n^2)
*/

public class Solution {
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        // initialization
        int[][] det = new int[n][n];
        for (int i = 0; i < n; i++) {
            det[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                det[i][i + 1] = 2;
            } else {
                det[i][i + 1] = 1;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    det[i][j] = det[i + 1][j - 1] + 2;
                }
                int sideMax = Math.max(det[i + 1][j], det[i][j - 1]);
                det[i][j] = Math.max(sideMax, det[i][j]);
            }
        }
        return det[0][n - 1];
    }
}
