/*
An amicable pair (m,n) consists of two integers m,n for which the sum of 
proper divisors (the divisors excluding the number itself) of one number equals the other.
Given an integer k, find all amicable pairs between 1 and k.

Example
Given 300, return [[220, 284]].
1+2+4+5+10+11+20+22+44+55+110 = 284
1+2+4+71+142 = 220
*/

public class Solution {
    /**
     * @param k an integer
     * @return all amicable pairs
     */
    //The factor sum of i exclude the number itself
    public int factorSum(int n){
        int sum=1,i;
        for(i=2;i*i<n;i++){
            if(n%i==0){
                sum=sum+i+n/i;
            }
        }
        if(i*i==n){
           sum=sum+i;
        }
        return sum;
    }
    
    public List<List<Integer>> amicablePair(int k) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //Start from 2, since sum is initiated to be 1
        for(int i=2; i<=k ;i++){
            int ami= factorSum(i);
            if(ami<=i ||ami>k){
                 continue;        //strat the next loop
            }
            if (factorSum(ami) == i) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(ami);
                result.add(pair);
            }
        }
        return result;
    }
    
}
