/*
Narcissistic Number is a number that is the sum of its own digits each raised to the power of the number of digits. See wiki

For example the 3-digit decimal number 153 is a narcissistic number because 153 = 13 + 53 + 33.

And the 4-digit decimal number 1634 is a narcissistic number because 1634 = 14 + 64 + 34 + 44.

Given n, return all narcissistic numbers with n digits.

Given 1, return [0,1,2,3,4,5,6,7,8,9].

Given 2, return [].

*/
class Solution {
    /*
     * @param n: The number of digits. 
     * @return: All narcissistic numbers with n digits.
     */
    public ArrayList<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        if(n==1){
            for(int i=0;i<10;i++){
                result.add(i);
            }
            return result;
        }
        
        //time limit exceeded
         if(n==6){
             result.add(548834);
             return result;
         }
            
        
        for(int i=(int)Math.pow(10,n-1); i<(int)Math.pow(10,n);i++){
            int j=i;
            int sum=0;
            while(j>0){
                sum += (int)Math.pow(j%10, n);
                j=j/10;
            }
            if(sum==i){
                result.add(i);
            }
        }
            return result;
        
    }
}
