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
        // time = O(logn), space = O(logn)
         if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }
        
        long product = fastPower(a, b, n / 2);
        // we cannot do product^3 too large
        product = product * product % b;
        return n % 2 == 1 ? (int) (product * a % b) : (int) product;
    }
}
