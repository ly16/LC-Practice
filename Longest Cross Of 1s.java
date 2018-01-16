/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, 
with the same arm lengths and the four arms joining at the central point.
Return the arm length of the largest cross.

Assumptions
The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples
{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.

time = O(m*n)
space = O(m*n)
*/



public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int m = matrix.length;
    if (m == 0) {
      return 0;
    }
    int n = matrix[0].length;
    if (n == 0) {
      return 0;
    }
    int[][] leftUpM = leftUp(matrix, m, n);
    int[][] rightDownM = rightDown(matrix, m, n);
    return merge(leftUpM, rightDownM, m, n);
  }
  
  private int[][] leftUp(int[][] matrix, int m, int n) {
    int[][] left = new int[m][n];
    int[][] up = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0 && j == 0) {
            left[i][j] = 1;
            up[i][j] = 1;
          } else if (i == 0) {
            up[i][j] = 1;
            left[i][j] = left[i][j - 1] + 1;
          } else if (j == 0) {
            left[i][j] = 1;
            up[i][j] = up[i - 1][j] + 1;
          } else {
            left[i][j] = left[i][j - 1] + 1;
            up[i][j] = up[i - 1][j] + 1;
          }
        }
      }
    }
    merge(left, up, m, n);
    return left;
  }
  
  private int[][] rightDown(int[][] matrix, int m, int n) {
    int[][] right = new int[m][n];
    int[][] down = new int[m][n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          if (i == m - 1 && j == n - 1) {
            right[i][j] = 1;
            down[i][j] = 1;
          } else if (i == m - 1) {
            down[i][j] = 1;
            right[i][j] = right[i][j + 1] + 1;
          } else if (j == n - 1) {
            right[i][j] = 1;
            down[i][j] = down[i + 1][j] + 1;
          } else {
            right[i][j] = right[i][j + 1] + 1;
            down[i][j] = down[i + 1][j] + 1;
          }
        }
      }
    }
    merge(right, down, m, n);
    return right;
  }
  
  private int merge(int[][] one, int[][] two, int m, int n) {
    int result  = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        one[i][j] = Math.min(one[i][j], two[i][j]);
        result = Math.max(result, one[i][j]);
      }
    }
    return result;
  }
}
