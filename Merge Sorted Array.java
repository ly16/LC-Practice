/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Example
A = [1, 2, 3, empty, empty], B = [4, 5]
After merge, A will be filled as [1, 2, 3, 4, 5]
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i=m-1, j=n-1, index=m+n-1;
        while(i>=0 && j>=0){
            if(A[i]>B[j]){
                //merge B into A
                A[index--]=A[i--];
            }else{
                A[index--]=B[j--];
            }
        }
        // one of two arrays is empty
        while(i>=0){
            A[index--]=A[i--];
        }
        while(j>=0){
            A[index--]=B[j--];
        }
    }
}

// leetcode version
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // fill from the right to the left
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
