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

// version 1
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


// version 2:
public class Solution {
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int[] tmp = new int[A.length];
        mergeSort(A, tmp, 0, A.length - 1);
    }
    
    private void mergeSort(int[] A, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(A, tmp, start, mid);
        mergeSort(A, tmp, mid + 1, end);
        merge(A, tmp, start, mid, end);
    }
    
    private void merge(int[] A, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (tmp[left] < tmp[right]) {
                A[index++] = tmp[left++];
            } else {
                A[index++] = tmp[right++];
            }
        }
        while (left <= mid) {
            A[index++] = tmp[left++];
        }
    }
}
