/*
Given a big sorted array with positive integers sorted by ascending order.
The array is so big so that you can not get the length of the whole array directly, 
and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). 
Find the first index of a target number. Your algorithm should be in O(log k), 
where k is the first index of the target number.
Return -1, if the number doesn't exist in the array.

Example
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.
Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.

time = O(log2n + logn) = O(logn) for jumping out and jumping in
space = O(1)
*/



public class Solution {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // you don't consider the boundary here
        // time = O(log2n + logn) = O(logn), space = O(n)
        if (reader.get(0) == target) {
            return 0;
        }
        
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        return FirstIndex(left, right, target, reader);
    }
    
    private int FirstIndex(int left, int right, int target, ArrayReader reader) {
        while (left + 1 < right) {
        int mid = left + (right - left) / 2;
            if (reader.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (reader.get(left) == target) {
            return left;
        } else if (reader.get(right) == target) {
            return right;
        }
        return -1;
    }
    
}
