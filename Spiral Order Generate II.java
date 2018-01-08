/*
Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, M * N in increasing order.

Assumptions
M >= 0, N >= 0

Examples
M = 3, N = 4, the generated matrix is

{ {1,  2,  3,  4}

  {10, 11, 12, 5},

  {9,  8,  7,  6} }



time = O(n)
space = O(1)
*/

public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    // Write your solution here.
    int[][] result = new int[m][n];
    if (m == 0 || n == 0) {
      return result;
    }
    
    int up = 0;
    int down = m - 1;
    int left = 0;
    int right = n - 1;
    int num = 1;
    
    while (up < down && left < right) {
      for (int i = left; i < right; i++) {
        result[up][i] = num++;
      }
      for (int i = up; i < down; i++) {
        result[i][right] = num++;
      }
      for (int i = right; i > left; i--) {
        result[down][i] = num++;
      }
      for (int i = down; i > up; i--) {
        result[i][left] = num++;
      }
      left++;
      right--;
      up++;
      down--;
    }
    
    if (left == right) {
      for (int i = up; i <= down; i++) {
        result[i][left] = num++;
      }
    } else {
      for (int i = left; i <= right; i++) {
        result[up][i] = num++;
      }
    }
    return result;
  }
}
