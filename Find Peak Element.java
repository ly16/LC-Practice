/*
There is an integer array which has the following features:
The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].

We define a position P is a peak if:
A[P] > A[P-1] && A[P] > A[P+1]

Example
Given [1, 2, 1, 3, 4, 5, 7, 6]
Return index 1 (which is number 2) or 6 (which is number 7)

time = O(logn)
space = O(1)
*/

public class Solution {
    public int findPeak(int[] A) {
        // one important idea is that A[0] < A[1] && A[A.length - 2] > A[A.lengt
        //  1].
        // time = O(logn), space = O(1)
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // left is mid or the right side of mid
            if (A[mid] < A[mid + 1]) {
                left = mid; 
            } else {
                right = mid;
            }
        }
        
        return A[left] > A[right] ? left : right;
    }
}
