/*
Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm
Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].

*/
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        quickSort(A, 0, A.length-1);
    }
    private void quickSort(int[]A, int start, int end){
        if(start>= end){
            return;
        }
        
        int left=start, right=end;
        //pivot is a value, not index
        int pivot=A[end+(start-end)/2];
        
        //4 left<=right
        while(left<=right){
            while(left<=right && A[left]<pivot){
                left++;
            }
            while(left<=right && A[right]>pivot){
                right--;
            }
            if(left<=right){
                int t=A[right];
                A[right]= A[left];
                A[left]=t;
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    } 
}
