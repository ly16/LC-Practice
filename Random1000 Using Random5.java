/*
Given a random generator random5(), 
the return value of random5() is 0 - 4 with equal probability. 
Use random5() to implement random1000()

time = O(1)
space = O(1)
*/

public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while (true) {
    	int num = 0;
      for (int i = 0;  i < 5; i++) {
      	num = num * 5 + RandomFive.random5();
      }
      
      if (num < 3000) {
      	return num % 1000;
      }
    }
  }
}
