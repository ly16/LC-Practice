/*
Reverse a 3-digit integer.

Example
Reverse 123 you will get 321.
Reverse 900 you will get 9.
*/
class Solution {
    /*
     * param number: A 3-digit number.
     * return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        return number%10*100+number/10%10*10+number/100;
    }
};
