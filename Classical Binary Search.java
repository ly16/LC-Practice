/*
Given a target integer T and an integer array A sorted in ascending order, find the index i 
such that A[i] == T or return -1 if there is no such index.

Example:
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

*/

public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here.
    if (array == null || array.length == 0){
      return -1;
    }
    
    int left = 0;
    int right = array.length - 1;
    
    while (left <= right){
      int mid = left + (right - left) / 2;
      if (array[mid] == target){
        return mid;
      } else if (array[mid] < target){
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
