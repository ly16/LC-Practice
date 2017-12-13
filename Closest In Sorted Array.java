/*
Given a target integer T and an integer array A sorted in ascending order, 
find the index i in A such that A[i] is closest to T.

A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
1 3 3 4
l m   r
1 3 3 4
l r
|1-2| compares with |3-2|


time = O(log(n))
space = O(1)
*/

public class Solution {
  public int closest(int[] array, int target) {
    // Write your solution here
    if (array == null ||  array.length == 0) {
      return -1;
    }
    
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    
    return (target - array[left]) <= (array[right] - target) ? left : right;
  }
}
