/*
Find the longest common substring of two given strings.

Assumptions
The two given strings are not null

Examples
S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”

time = O(mn)
space = O(mn)
*/

public class Solution {
  public String longestCommon(String s, String t) {
    // Write your solution here.
    // s, t are not null
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    int start = 0;
    int largest = 0;
    int[][] matrix = new int[sArray.length][tArray.length];
    for (int i = 0; i < sArray.length; i++) {
    	for (int j = 0; j < tArray.length; j++) {
      	if (sArray[i] == tArray[j]) {
        	if (i == 0 || j == 0) {
          	matrix[i][j] = 1;
          } else {
          	matrix[i][j] = matrix[i - 1][j - 1] + 1;
          }
          if (largest < matrix[i][j]) {
          	largest = matrix[i][j];
            start = i - largest + 1;
          }
        }
      }
    }
    return s.substring(start, start + largest);
  }
}
