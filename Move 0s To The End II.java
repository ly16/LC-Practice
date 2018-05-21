/*
Given an array of integers, move all the 0s to the right end of the array.
The relative order of the elements in the original array need to be maintained.

Assumptions:
The given array is not null.

Examples:
{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}

time = O(n)
space = O(1)
*/

public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return array;
    }
    int slow = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        array[slow++] = array[i];
      }
    }
    
    while (slow < array.length) {
      array[slow++] = 0;
    }
    
    return array;
  }
}


// leetcode version
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
