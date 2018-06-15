/*
Determine if a given integer is power of 2.

Examples
16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not

time = O(1)
space = O(1)
*/

public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here.
  	if (number <= 0) {
    	return false;
    }
    while ((number & 1) == 0) {
      number >>>= 1;
    }
    return number == 1;
  }
}


// method 2:
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // trick here
        return (n&(n-1)) == 0;
    }
}
