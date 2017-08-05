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
    if(array==null || array.length <= 1){
      return array;
    }
    int[] helper= new int[array.length];
    mergeSort(array, helper, 0, array.length-1);
    return array;
  }
  
  private void mergeSort(int[] array, int[] helper, int left, int right){
    // seperate until single element
    if(left == right){
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }
  
  private void merge(int[] array, int[] helper, int left, int mid, int right){
    for(int i = left; i <= right; i++){
      helper[i] = array[i];
    }
    int li = left;
    int ri = mid + 1;
    while(li <= mid && ri <= right){
      // Move the smaller one
      if(helper[li] <= helper[ri]){
        array[left++] = helper[li++];
      }else{
        array[left++] = helper[ri++];
      }
    }
    /* if there are some elements at left side, move into the array, but we do 
    ** not move right side since already in their right positions*/
    while(li <= mid){
      array[left++] = helper[li++];
    }
  }
}
