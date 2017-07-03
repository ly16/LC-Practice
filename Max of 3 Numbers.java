/*
Given 3 integers, return the max of them.
Example
Given num1 = 1, num2 = 9, num3 = 0, return 9.
*/

public class Solution {
    /**
     * @param num1 an integer
     * @param num2 an integer
     * @param num3 an integer
     * @return an integer
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // Write your code here
        if(num1>=num2 && num1>=num3)
        {
            return num1;
        }else if(num2>=num1 && num2>=num3)
        {
            return num2;
        }else 
        {
            return num3;    
        }
    }
}
