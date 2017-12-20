/*
Java: Implement a queue by using two stacks. 
The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
When the queue is empty, poll() and peek() should return null.

Assump:
Elements are all Integers.

amortized time = O(1)
space = O(n)
*/



public class Solution {
  private Deque<Integer> in;
  private Deque<Integer> out;
  public Solution() {
    // Write your solution here.
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  
  public Integer poll() {
    move();
    return out.isEmpty() ? null : out.pollFirst();
  }
  
  public void offer(int element) {
    in.offerFirst(element);
  }
  
  public Integer peek() {
    move();
    return out.isEmpty() ? null : out.peekFirst();
  }
  
  public void move() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerFirst(in.pollFirst());
      }
    }
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    return (in.size() == 0 && out.size() == 0);
  }
}






