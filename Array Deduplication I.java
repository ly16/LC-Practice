/*
Given a sorted integer array, remove duplicate elements. 
For each group of elements with the same value keep only one of them. 
Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. 
Return the array after deduplication.

Assumptions
The array is not null

Examples
{1, 2, 2, 3, 3, 3} → {1, 2, 3}

time = O(n)
space = O(1)
*/


// while version
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
      if (array[fast] != array[slow]) {
        array[++slow] = array[fast++];
      } else {
        fast++;
      }
    }
    return slow + 1;
  }
}


// for version
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            nums[++i] = nums[j];
        }
    }
    return i + 1;
}
