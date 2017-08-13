/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix.
If the target number does not exist in the matrix, return {-1, -1}.

matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
target = 7, return {1, 2}
target = 6, return {-1, -1}
steps:(target = 7)
1 2 3
l
4 5 7
m
8 9 10
    r
    
1 2 3

4 5 7
  l
8 9 10
m    r  

1 2 3

4 5 7
  l r
8 9 10

1 2 3

4 5 7
    lr
8 9 10
*/


public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here.
    if(matrix.length == 0 || matrix[0].length == 0){
      return new int[] {-1, -1};
    }
    
    // convert 2D to 1D array
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = row * col - 1;
    
    while (left <= right){
      int mid = left + (right - left) / 2;
      int midr = mid / col;
      int midc = mid % col;
      if (matrix[midr][midc] == target){
        return new int[] {midr, midc};
      } else if (matrix[midr][midc] < target){
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
   return new int[] {-1, -1};
  }
}
