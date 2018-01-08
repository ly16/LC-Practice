/*
Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions
The 2D array is not null and has size of N * N where N >= 0
Examples

{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]


time = O(n*n)
space = O(n)
*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (matrix.length == 0) {
      return result;
    }
    if (matrix[0].length == 0) {
      return result;
    }
    int start = 0;
    int end = matrix.length - 1;
    
    while (start < end) {
      for (int i = start; i < end; i++) {
        result.add(matrix[start][i]);
      }
      for (int i = start; i < end; i++) {
        result.add(matrix[i][end]);
      }
      for (int i = end; i > start; i--) {
        result.add(matrix[end][i]);
      }
      for (int i = end; i > start; i--) {
        result.add(matrix[i][start]);
      }
      start++;
      end--;
    }
    if (start == end) {
      result.add(matrix[end][end]);
    }
    return result;
  }
}

