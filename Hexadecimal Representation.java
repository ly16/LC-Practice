/*
Generate the hexadecimal representation for a given non-negative integer number as a string. 
The hex representation should start with "0x".
There should not be extra zeros on the left side.

Examples
0's hex representation is "0x0"
255's hex representation is "0xFF"


time = O(n) for the reversed string
space = O(1)
*/

public class Solution {
  public String hex(int number) {
    // number >= 0
    String prefix = "0x";
    if (number == 0) {
    	return prefix + "0";
    }
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
    	int rem = number % 16;
      if (rem < 10) {
      	sb.append((char)('0' + rem));
      } else {
      	sb.append((char)(rem - 10 + 'A'));
      }
    	number >>>= 4; 
    }
    return prefix + sb.reverse().toString();
  }
}
