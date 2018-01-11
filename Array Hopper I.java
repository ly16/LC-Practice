/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
Determine if you are able to reach the last index.

Assumptions
The given array is not null and has length of at least 1.

Examples
{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
{2, 1, 1, 0, 2}, we are not able to reach the end of array

time = O(n^2)
space = O(n)  for the boolean array
*/

public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here.
    boolean[] canJump = new boolean[array.length];
    canJump[0] = true;
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        if (canJump[j] && j + array[j] >= i) {
          canJump[i] = true;
          break;
        }
      }
    }
    return canJump[array.length - 1];
  }
}
