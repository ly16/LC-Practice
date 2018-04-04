/*
Given an array of integers, sort the elements in the array in ascending order. 
time = O(nlog(n)) on average = O(n^2) worst case
space = O(log(n)) on average = O(n) worst case

Example
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
steps:
4 2 -3 6 1
pivot = 2
find the position of pivot
4 -3 6 1 2
1 -3 6 4 2
1 -3 2 6 4
then
-3 1 2 6 4 for the left
-3 1 2 4 6 for the right
*/


public class Solution {
  public int[] quickSort(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 1) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }
  
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotPos = partition(array, left, right);
    quickSort(array, left, pivotPos - 1);
    quickSort(array, pivotPos + 1, right);
  }
  
  private int partition(int[] array, int left, int right) {
    int pivotIndex = getPivot(left, right);
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, right);
    // two pointers
    int leftIndex = left;
    int rightIndex = right - 1;
    while (leftIndex <= rightIndex) {
      if (array[leftIndex] < pivot) {
        leftIndex++;
      } else if (array[rightIndex] > pivot) {
        rightIndex--;
      } else {
        swap(array, leftIndex++, rightIndex--);
      }
    }
    swap(array, leftIndex, right);
    return leftIndex;
  }
  
  private int getPivot(int left, int right) {
    return left + (int) (Math.random() * (right - left + 1));
  }
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}


// Version 2:
public class Solution {
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivotIndex = pivotGener(A, left, right);
        int pivot = A[pivotIndex];
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            } 
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(A, left++, right--);
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
    
    private int pivotGener(int[] A, int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }
    
    private void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
