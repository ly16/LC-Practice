/*
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
Example
Given [1,2,2,1,3,4,3], return 4
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        if(A==null ||A.length==0){
            return 0;
        }

        // All of duplicated numbers will be cancelled in the end
        int result=0;
        for(int i=0;i<A.length;i++){
            result ^= A[i];
        }
        return result;
    }
}
