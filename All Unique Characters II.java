/*
Determine if the characters of a given string are all unique.

Assumptions
We are using ASCII charset, the value of valid characters are from 0 to 255
The given string is not null

Examples
all the characters in "abA+\8" are unique
"abA+\a88" contains duplicate characters

time = O(n)
space = O(n)
*/

public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here
    int[] vec = new int[8];
    char[] array = word.toCharArray();
    for (char c : array) {
    	if ((vec[c / 32] >>> (c % 32) & 1) != 0) {
      	return false;
      }
      vec[c / 32] |= (1 << (c % 32));
    }
    return true;
  }
}
