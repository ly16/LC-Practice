/*
Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. 
Use random5() to implement random7().

time = O(1)
space = O(1)
*/


public class Solution {
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while (true) {
    	int random = 5 * RandomFive.random5() + RandomFive.random5();
      if (random < 21) {
      	return random % 7;
      }
    }
  }
}
