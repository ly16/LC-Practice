/*
Given an array of integers, sort the elements in the array in ascending order. 

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
    if(array==null || array.length <= 1){
      return array;
    }
    quickSort(array, 0, array.length-1);
      return array;
  }
  public void quickSort(int[] array, int left, int right){
    //if left==pivotPos, left>pivotPos-1
    if(left >= right){
      return;
    }
    int pivotPos = partition(array, left, right);
    // exclude pivot
    quickSort(array, left, pivotPos - 1);
    quickSort(array, pivotPos + 1, right);
  }
  private int partition(int[] array, int left, int right){
    int pivoti = pivoti(left, right);
    int pivot = array[pivoti];
    // swap pivot to the right end of the array
    swap(array, pivoti, right);
    int li = left;
    int ri = right - 1;
    while(li <= ri){
      if(array[li] < pivot){
        li++;
      }else if(array[ri] >= pivot){
        ri--;
      }else{
        swap(array, li++, ri--);    // stop when both are stucked
      }
    }
    //swap pivot to the correct position
    swap(array, li, right);
    return li;
  }
  //choose pivot randomly
  private int pivoti(int left, int right){
    return left + (int)(Math.random() * (right-left+1));
  }
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
