/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, 
find the K closest numbers to T in A.
time = O(logn + k)

A size K integer array containing the K closest numbers(not indices) in A, 
sorted in ascending order by the difference between the number and T. 

A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
steps:
1 4 6 8
l m   r
1 4 6 8
l r
4 > 3 but 1 < 3
so left = 0, right = 1;
3 - 1 > 4 - 3 so return 4
1 4 6 8
l   r
3 - 1 < 6 - 3 so return 1
  1 4 6 8
l     r
l = -1 < 0 so just move the right side 6 in the array


time = O(log(n) + k)
space = O(k)
*/

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array;
    }
    if (k == 0) {
      return new int[0];
    }
    int left = smallerOrQqual(array,target);
    int right = left + 1;
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      if (right >= array.length || (left >= 0 && target - array[left] <= array[right] - target)) {
        result[i] = array[left--];
      } else {
        result[i] = array[right++];
      }
    }
    return result;
  }
  
  private int smallerOrQqual(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    
    if (array[right] <= target) {
      return right;
    } else if (array[left] <= target) {
      return left;
    }
    return -1;
  }
}
