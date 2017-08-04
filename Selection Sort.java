/*
Given an array of integers, sort the elements in the array in ascending order. 
The selection sort algorithm should be used to solve this problem.
time=O(n^2),extra space=O(1)

Examples
{1} is sorted to {1}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
steps:
-3 {4,2,6,1}
-3 1 {4,2,6}
-3 1 2 {4,6}
-3 1 2 4 6
*/

public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here.
    if(array==null || array.length<=1){
      return array;
    }
    for(int i=0; i < array.length-1; i++){
      int min=i;
      // Find the min value of the right, and give index to min
      for(int j=i+1; j < array.length; j++){
        if(array[j] < array[min]){
          min=j;
        }
      }
      swap(array, i, min);
    }
    return array;
  }
  
  public void swap(int[] array, int left, int right){
    int temp=array[left];
    array[left]=array[right];
    array[right]=temp;
  }
}
