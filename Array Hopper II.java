/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). 
Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions
The given array is not null and has length of at least 1.

Examples
{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.

time = O(n^2)
space = O(n)
*/

public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return -1;
    }
    int[] canJump = new int[array.length];
    canJump[0] = 0;
    for (int i = 1; i < array.length; i++) {
      canJump[i] = -1;
      for (int j = 0; j < i; j++) {
        if (canJump[j] != -1 && array[j] + j >= i) {
          if (canJump[i] == -1 || canJump[i] > canJump[j] + 1) {
            canJump[i] = canJump[j] + 1;
          }
        }
      }
    }
    return canJump[array.length - 1];
  }
}
