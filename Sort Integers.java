/*
Given an integer array, sort it in ascending order. 
Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        int n = A.length;
        for(int i=0; i<n ;i++){
            for(int j=i+1; j<n; j++){
            //if the later one is smaller than the previous one, exchange them.
                if(A[i]>A[j]){
                    int t= A[j];
                    A[j]= A[i];
                    A[i]= t;
                }
            }
        }
    }
}
