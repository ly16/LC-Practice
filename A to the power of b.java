/*
Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 
Recursion: 
power(2, 0) = 1
power(0, 23) = 0

eg. 2^100
      50
      25
      12 (1)
      6
      3
      1 (1)
      0
  time = O(logn)
  space =  O(logn)
*/

public class Solution {
  public long power(int a, int b) {
    // Write your solution here, time = O(logn), space = o(logn)
    if (a == 0){
      return 0;
    }
    if (b == 0){
      return 1;
    }
    // Recursion
    long half = power(a, b / 2);
    return b % 2 == 0 ? half * half : half * half *a;
  }
}
