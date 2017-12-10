/*
Given an array of integers, sort the elements in the array in ascending order. 
The merge sort algorithm should be used to solve this problem.
Example
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
steps:
4 2 -3 6 1
4 2 -3   6 1
4 2   -3    6   1
4   2   -3    6   1
====================
2 4   -3    1 6
-3 2 4    1 6
-3 1 2 4 6

time=O(nlogn)
space=o(n)
*/


public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return array;
    }
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }
  
  private void mergeSort(int[] array, int[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }
  
  private void merge(int[] array, int[] helper, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    int leftIndex = left;
    int rightIndex = mid + 1;
    while (leftIndex <= mid && rightIndex <= right) {
      if (helper[leftIndex] < helper[rightIndex]) {
        array[left++] = helper[leftIndex++];
      } else {
        array[left++] = helper[rightIndex++];
      }
    }
    // if there are still items in left part
    while (leftIndex <= mid) {
      array[left++] = helper[leftIndex++];
    }
  }
}
