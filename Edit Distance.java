/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, 
and Insert operations needed to transform one string into the other.


Assumptions
Both strings are not null

Examples
string one: “sigh”, string two : “asith”
the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).

time = O(m*n)
space = O(m*n)
*/

public class Solution {
  public int editDistance(String one, String two) {
    // Write your solution here.
    int[][] matrix = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i < one.length() + 1; i++) {
      for (int j = 0; j < two.length() + 1; j++) {
        if (i == 0) {
          matrix[i][j] = j;
        } else if (j == 0) {
          matrix[i][j] = i;
        } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
          matrix[i][j] = matrix[i - 1][j - 1];
        } else {
          matrix[i][j] = Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1);
          matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, matrix[i][j]);
        }
      }
    }
    return matrix[one.length()][two.length()];
  }
}
