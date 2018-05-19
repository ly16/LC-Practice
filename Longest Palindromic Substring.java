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
space = O(1)    space = O(n^2) for 2-d dp
*/

/* Method 1 enumeration */
public class Solution {
  public String longestPalindrome(String s) {
    // Write your solution here
    if (s == null || s.length() == 0) {
    	return "";
    }
    
    int longest = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      int length = getLen(s, i, i);
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
    // end exclusive
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


/* Method 2 dp */
public class Solution {
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int start = 0;
        int longest = 1;
        boolean[][] det = new boolean[n][n];
        // initialization
        for (int i = 0; i < n; i++) {
            det[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            det[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (det[i][i + 1]) {
                start = i;
                longest = 2;
            }
        }  
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && det[i + 1][j - 1]) {
                    det[i][j] = true;
                    if (j - i + 1 > longest) {
                        longest = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + longest);
    }
}
