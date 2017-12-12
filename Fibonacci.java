/*
ind the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
1  2  3  4  ...     ...      k  ...

Example
Given 1, return 0

Given 2, return 1

Given 10, return 34

time = O(n)
space = O(1)
*/

public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0;
    }
    long a = 0;
    long b = 1;
    while (K > 1) {
      long temp = a + b;
      a = b;
      b = temp;
      K--;
    }
    return b;
  }
}

