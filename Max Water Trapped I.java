/*
Given a non-negative integer array representing the heights of a list of adjacent bars. 
Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions
The given array is not null
(you still need to check length)

Examples
{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 
(at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)


time = O(n)
space = O(1)
*/


public class Solution {
  public int maxTrapped(int[] array) {
    // Write your solution here
    if (array.length <= 1) {
    	return 0;
    }
    int left = 0;
    int right = array.length - 1;
    int lMax = array[0];
    int rMax = array[array.length - 1];
    int result = 0;
    while (left < right) {
    	lMax = Math.max(array[left], lMax);
      rMax = Math.max(array[right], rMax);
      if (lMax < rMax) {
      	result += lMax - array[left++];
      } else {
      	result += rMax - array[right--];
      }
    }
    return result;
  }
}
