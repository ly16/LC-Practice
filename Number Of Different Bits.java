/*
Determine the number of bits that are different for two given integers.

Examples
5(“0101”) and 8(“1000”) has 3 different bits

time = O(1)
space = O(1)
*/


public class Solution {
  public int diffBits(int a, int b) {
    // Write your solution here
    a ^= b;
    int count = 0;
    while (a != 0) {
    	count += (a & 1);
      a >>>= 1;
    }
    return count;
  }
}
