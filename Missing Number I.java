/*
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

time = O(n), space = O(n)
*/

public class Solution {
  public int missing(int[] array) {
    // Write your solution here.
    int n = array.length + 1;
    Set<Integer> set = new HashSet<>();
    for (int i : array) {
      set.add(i);
    }
    for (int j = 1; j < n; j++) {
      if (!set.contains(j)) {
        return j;
      }
    }
    return n;
  }
}
