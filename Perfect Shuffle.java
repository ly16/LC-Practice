/*
Given an array of integers (without any duplicates), 
shuffle the array such that all permutations are equally likely to be generated.

Assumptions
The given array is not null

time = O(n)
space = O(1)
*/

public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
    	return;
    }
    for (int i = 0; i < array.length; i++) {
    	int tmp = array[i];
      int delta = (int) (Math.random() * (array.length - i));
      tmp = array[i + delta];
      array[i + delta] = array[i];
      array[i] = tmp;
    }
  }
}
