/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Use maxHeap can online(real-time) sorting and reduce space complexity when n is large.
1. heapify O(n)
2. offer n-k elements to the maxHeap (n-k)logk
time = O(n + (n-k)logk)
*/

public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if(array.length == 0 || k == 0){
      return new int[0];
    }
    // definetion of priorityQueue
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2){
        // not ==, because Integer is object
        if(o1.equals(o2)){
          return 0;
        }
        return o1 > o2 ? -1 : 1;
      }
    });
    
    for (int i = 0; i < array.length; i++){
      if(i < k){  // first k elements
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()){
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--){ //ascending order
      result[i] = maxHeap.poll();
    }
    return result;
  }
    
}
