/*
Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest X shape.

Assumptions
The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples
{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest X of 1s has arm length 2.

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
    
    int[][] up = getUp(matrix, m, n);
    int[][] down = getDown(matrix, m, n);
    return merge(up, down, m, n);
  }
  
  private int[][] getUp(int[][] matrix, int m, int n) {
    int[][] leftUp = new int[m][n];
    int[][] rightUp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          leftUp[i][j] = getNum(leftUp, i - 1, j - 1, m, n) + 1;
          rightUp[i][j] = getNum(rightUp, i - 1, j + 1, m, n) + 1;
        }
      }
    }
    merge(leftUp, rightUp, m, n);
    return leftUp;  
  }
  
  private int[][] getDown(int[][] matrix, int m, int n) {
    int[][] leftDown  = new int[m][n];
    int[][] rightDown = new int[m][n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          leftDown[i][j] = getNum(leftDown, i + 1, j - 1, m, n) + 1;
          rightDown[i][j] = getNum(rightDown, i + 1, j + 1, m, n) + 1;
        }
      }
    }
    merge(leftDown, rightDown, m, n);
    return leftDown;
  }
  
  private int merge(int[][] one, int[][] two, int m, int n) {
    int result = 0;
    for (int  i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        one[i][j] = Math.min(one[i][j], two[i][j]);
        result = Math.max(result, one[i][j]);
      }
    }
    return result;
  }
  
  private int getNum(int[][] matrix, int i, int j, int m, int n) {
    if (i < 0 || i > m - 1 || j < 0 || j > n -1) {
      return 0;
    }
    return matrix[i][j];
  }
}
