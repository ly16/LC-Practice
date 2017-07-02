/*
Write a function that add two numbers A and B. You should not use + or any arithmetic operators.

Clarification
Are a and b both 32-bit integers?

Yes.
Can I use bit operation?

Sure you can.
Example
Given a=1 and b=2 return 3
*/

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
    
        while(b!=0)
        {
          int a1=a ^ b;
          int b1=(a & b)<<1;
          a=a1;
          b=b1;
        }
        return a;
    }
};
