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

*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        long a=0;
        long b=1;
        
        for(int i = 3;i <= n;i++){
            long temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }
}

