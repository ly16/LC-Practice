/*
Given a matrix that contains integers, find the submatrix with the largest sum.
Return the sum of the submatrix.

Assumptions
The given matrix is not null and has size of M * N, where M >= 1 and N >= 1

Examples
{ {1, -2, -1, 4},

  {1, -1,  1, 1},

  {0, -1, -1, 1},

  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.

time = O(m*n^2) = O(n^3)
space = O(m)
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
    
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      int[] cur = new int[n];
      for (int j = i; j < m; j++) {
        add(matrix[j], cur);
        result = Math.max(result, dpMax(cur));
      }
    }
    return result;
  }
  
  private void add(int[] array, int[] cur){
    for (int i = 0; i < array.length; i++) {
      cur[i] += array[i];
    }
  }
  
  private int dpMax(int[] cur) {
    int max = cur[0];
    int temp = cur[0];
    for (int i = 1; i < cur.length; i++) {
        temp = Math.max(cur[i], cur[i] + temp);
        max = Math.max(max, temp);
    }
    return max;
  }
}
