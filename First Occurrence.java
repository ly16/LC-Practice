/*
Given a target integer T and an integer array A sorted in ascending order, 
find the index of the first occurrence of T in A or return -1 if there is no such index.

A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 1
steps:
1 2 2 2 3
l   m   r
1 2 2 2 3
l m r
1 2 2 2 3
l r
check array[left] and array[right]

*/

public class Solution {
  public int firstOccur(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0){
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right){   // leave two numbers
      int mid = left + (right - left) / 2;
      if (array[mid] == target){
        right = mid;
      } else if (array[mid] > target){
        right = mid - 1;        // or right = mid
      } else {
        left = mid + 1;         // or left = mid
      }
    }
    
    // check left side first for the first occurrence
    if (array[left] == target){
      return left;
    }
    if (array[right] == target){
      return right;
    }
    return -1;
  }
}
