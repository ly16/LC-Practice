/*
Prime factorize a given integer.
Given 10, return [2, 5].
Given 660, return [2, 2, 3, 5, 11].

*/

public class Solution {
    /**
     * @param num an integer
     * @return an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // Write your code here
        List<Integer> factor= new ArrayList(); 
        
        for(int i=2; i*i<=num; i++){
            while(num%i ==0 ){
                num=num/i;
                factor.add(i);
            }
        }
        //prime num
        if(num!=1){
            factor.add(num);
        }
        
        return factor;
    }
}
