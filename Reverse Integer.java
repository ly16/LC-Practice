/*
Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
Given x = 123, return 321

Given x = -123, return -321


*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        int reversed_n = 0;
        
        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            //overflows below
            if(temp/10 != reversed_n){
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    
    }
}
