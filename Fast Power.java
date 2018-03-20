/*
Calculate the a^n % b where a, b and n are all 32bit integers.

Example
For 2^31 % 3 = 2
For 100^1000 % 1000 = 0

time = O(logn)
space = O(logn)
*/

public class Solution {
    public int fastPower(int a, int b, int n) {
         if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }
        
        int product = fastPower(a, b, n / 2);
        
        if (n % 2 == 1) {
            return (int) (product * product * a * 1L) % b;
        }
        return (int) (product * product * 1L) % b;
    }
}
