/*
Given a string S, find the longest palindromic substring in S.

Assumptions
There exists one unique longest palindromic substring.    
The input S is not null.

Examples
Input:     "abbc"
Output:  "bb"
Input:     "abcbcbd"
Output:  "bcbcb"

time = O(n^2)
space = O(1)
*/


public class Solution {
  public String longestPalindrome(String s) {
    // Write your solution here
    if (s.length() <= 0) {
    	return "";
    }
    int left = 0;
    int right = 0;
    int length = 0;
    int longest = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      length = getLen(s, i, i);
      if (length > longest) {
      	longest = length;
        start = i - longest / 2;
      }
      
      length = getLen(s, i, i + 1);
      if (length > longest) {
      	longest = length;
        start = i - longest / 2 + 1;
      }
    }
    return s.substring(start, start + longest);
  }
  
  private int getLen(String s, int left, int right) {
    int len = 0;
  	while (left >= 0 && right < s.length()) {
    	if (s.charAt(left) != s.charAt(right)) {
      	break;
      }
      len += left == right ? 1 : 2;
      left--;
      right++;
    }
    return len;
  }
}
