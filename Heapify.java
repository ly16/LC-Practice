/*
Description
Given an integer array, heapify it into a min-heap array.
For a heap array A, A[0] is the root of heap, and for each A[i], 
A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].

Clarification
What is heap?
Heap is a data structure, which usually have three methods: 
push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, 
"top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. 
If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.

Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Challenge
O(n) time complexity

time = O(n/2 + n/4 + ...) = O(n)
space  = O(1)
*/

public class Solution {
    private void siftdown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;   // left son
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2])
                son = k * 2 + 2;     // the smaller of left and right son
            if (A[son] > A[k])     // son is larger then father 
                break;
            
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }
    
    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
}
