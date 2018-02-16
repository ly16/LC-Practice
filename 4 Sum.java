/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions
The given array is not null and has length of at least 4

Examples
A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
A = {1, 2, 2, 3, 4}, target = 12, return false


time = O(n^2)
space = O(n) for a hashmap
*/


public class Solution {
  static class Pair {
  	int left;
    int right;
    Pair(int left, int right){
    	this.left = left;
      this.right = right;
    }
  }
  public boolean exist(int[] array, int target) {
    // Write your solution here
    Map<Integer, Pair> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
    	for (int j = 0; j < i; j++) {
      	int pairSum = array[j] + array[i];
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
        	return true;
        } 
        if (!map.containsKey(pairSum)) {
        	map.put(pairSum, new Pair(j, i));
        }
      }
    }
    return false;
  }
}
