/*
Description
Given an integer array, find the top k largest numbers in it.

Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].


time = O(nlogk)
space = O(k) for the heap
*/

public class Solution {
    public int[] topk(int[] nums, int k) {
        // write your code here
        int[] result = new int[k];
        if (nums == null) {
            return result;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> (k, new Comparator<Integer>() {
            @Override
            public int compare( Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? -1 : 1;
            }
        });
        
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        for (int i = k - 1; i >= 0 ; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
