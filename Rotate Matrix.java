/*
Rotate an N * N matrix clockwise 90 degrees.

Assumptions
The matrix is not null and N >= 0

Examples
{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }


time = O(n*n)
space = O(1)
*/

public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    if (n <= 1) {
      return;
    }
    int round = n / 2;
    for (int level = 0; level < round; level++) {
      int start = level;
      int end = n - level - 2;
      for (int i = start; i <= end; i++) {
        int tmp = matrix[start][i];
        matrix[start][i] = matrix[n - i - 1][start];
        matrix[n - i - 1][start] = matrix[end + 1][n - i - 1];
        matrix[end + 1][n - i - 1] = matrix[i][end + 1];
        matrix[i][end + 1] = tmp;
      }
    }
  }
}
