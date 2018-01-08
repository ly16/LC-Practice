/*
Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions
The 2D array is not null and has size of M * N where M, N >= 0
Examples

{ {1,  2,  3,  4},

  {5,  6,  7,  8},

  {9, 10, 11, 12} }

the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]


time = O(n)
space = O(1)
*/

public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        
        while (left < right && up < down) {
            for (int i = left; i < right; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up; i < down; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down; i > up; i--) {
                result.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }    
            if (left > right || up > down) {
                return result;
            }
            if (left == right) {
                for (int i = up; i <= down; i++) {
                    result.add(matrix[i][left]);
                }
            } else {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[up][i]);
                }
            }

        return result;
    }
}
