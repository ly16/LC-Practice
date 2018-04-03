/*
Given two numbers, number a and number b. 
Find the greatest common divisor of the given two numbers.

Example
Given a = 10, b = 15, return 5.
Given a = 15, b = 30, return 15.

time = O(logn)
space = O(logn)
*/

public class Solution {
    public int gcd(int a, int b) {
        int large = a >= b ? a : b;
        int small = a >= b ? b : a;
        if (small != 0) {
            return gcd(small, large % small);
        } else {
            return large;
        }
    }
}
