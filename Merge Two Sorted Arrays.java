/*
Merge two given sorted integer array A and B into a new sorted integer array.

Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if(A==null || B==null){
            return null;
        }
        int[] result=new int[A.length+B.length];
        int i=0,j=0,index=0;
        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                result[index++]=A[i++];
            }
            else{
                result[index++]=B[j++];
            }
        }
        while(i<A.length){
            result[index++]=A[i++];
        }
        while(j<B.length){
            result[index++]=B[j++];
        }
        return result;
    }
}
