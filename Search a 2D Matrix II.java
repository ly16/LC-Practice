/*
Write an efficient algorithm that searches for a value in an m x n matrix, 
return the occurrence of it.
This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.

Example
Consider the following matrix:
[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

time = O(n + m)
space = O(1)
*/

public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        // linear of length and width
        // from the lower left, with smaller upper and larger on right side
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        int count = 0;
        
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) {
                y++;
                x--;
                count++;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return count;
    }
}
