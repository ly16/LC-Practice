/*
Find the length of longest common subsequence of two given strings.

Assumptions
The two given strings are not null

Examples
S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.

time = O(mn)
space = O(mn)
*/

public class Solution {
  public int longest(String s, String t) {
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    int[][] common = new int[sArray.length + 1][tArray.length + 1];
    for (int i = 1; i < sArray.length + 1; i++) {
    	for (int j = 1; j < tArray.length + 1; j++) {
      	if (sArray[i - 1] == tArray[j - 1]) {
        	common[i][j] = common[i - 1][j - 1] + 1;
        } else {
        	common[i][j] = Math.max(common[i][j - 1], common[i - 1][j]);
        }
      }
    }
    return common[s.length()][t.length()];
  }
}
