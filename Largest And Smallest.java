/*
Use the least number of comparisons to get the largest and smallest number in the given integer array. 
Return the largest number and the smallest number.

Assumptions
The given array is not null and has length of at least 1

Examples
{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].

time = O(1.5n) = O(n)
space = O(1)
*/

public class Solution {
  public int[] largestAndSmallest(int[] array) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the smallest number.
    if (array == null || array.length == 0) {
      return new int[] {0, 0};
    }
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] < array[n - 1- i]) {
        swap(array, i, n - 1- i);
      }
    }
    return new int[] {largest(array, 0, n / 2), smallest(array, n / 2, n - 1)};
  }
  
  private int largest(int[] array, int left, int right) {
    int largest = array[left];
    for (int i = 1; i <= right; i++) {
      largest = Math.max(array[i], largest);
    }
    return largest;
  }
  
  private int smallest(int[] array, int left, int right) {
    int smallest = array[left];
    for (int i = 1; i <= right; i++) {
      smallest = Math.min(array[i], smallest);
    }
    return smallest;
  }
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
