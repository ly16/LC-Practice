/*
Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
You will have to implement the following two methods for the class
read(int value) - read one value from the flow
median() - return the median at any time, return null if there is no value read so far

Examples
read(1), median is 1
read(2), median is 1.5
read(3), median is 2
read(10), median is 2.5

time = O(nlogn)
space = O(n) for the priorityQueue
*/


public class Solution {
  private PriorityQueue<Integer> smallerHalf;
  private PriorityQueue<Integer> largerHalf;
  public Solution() {
    smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
    largerHalf = new PriorityQueue<>();
  }
  
  public void read(int value) {
    // write your implementation here.
    if (smallerHalf.isEmpty() || value < smallerHalf.peek()) {
    	smallerHalf.offer(value);
    } else {
    	largerHalf.offer(value);
    }
    
    if (smallerHalf.size() > largerHalf.size() + 1) {
    	largerHalf.offer(smallerHalf.poll());
    } else if (smallerHalf.size() < largerHalf.size()) {
    	smallerHalf.offer(largerHalf.poll());
    }
  }
  
  public Double median() {
    // write your implementation here.
    int size = smallerHalf.size() + largerHalf.size();
    if (size == 0) {
    	return null;
    } else if (size % 2 == 0) {
    	return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
    } else {
    	return (double) smallerHalf.peek();
    }
  }
}
