/*
Given an array and two indexes, swap the integers on the two indices.
Given [1,2,3,4] and index1 = 2, index2 = 3. The array will change to [1,2,4,3] after swapping. 
You don't need return anything, just swap the integers in-place.
*/
public class Solution {
    public void swapIntegers(int[] A, int index1, int index2) {
        int temp=A[index1];
        A[index1]=A[index2];
        A[index2]=temp;
       }
    }
