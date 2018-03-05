/*
Given three strings A, B and C. Determine if C can be created by merging A and B 
in a way that maintains the relative order of the characters in A and B.

Assumptions
none of A, B, C is null

Examples
C = "abcde", A = "acd", B = "be", return true
C = "abcde", A = "adc", B = "be", return false

time = O(n^2)
space = O(n^2)
*/

public class Solution {
  public boolean canMerge(String a, String b, String c) {
    // Write your solution here
    int alen = a.length();
    int blen = b.length();
    int clen = c.length();
    if (alen + blen != clen) {
    	return false;
    }
    
    boolean[][] det = new boolean[alen + 1][blen + 1];
    for (int i = 0; i <= alen; i++) {
    	for (int j = 0; j <= blen; j++) {
      	if (i == 0 && j == 0) {
        	det[i][j] = true;
        }
        if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
        	det[i][j] |= det[i - 1][j];
        }
        if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
        	det[i][j] |= det[i][j - 1];
        }
      }
    }
    return det[alen][blen];
  }
}
