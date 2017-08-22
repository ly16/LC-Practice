/*
Java: Implement a queue by using two stacks. 
The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
When the queue is empty, poll() and peek() should return null.

Assump:
Elements are all Integers.

*/



public class Solution {
  private LinkedList<Integer> in; // insert into in stack
  private LinkedList<Integer> out;  // remove from out stack
  
  public Solution() {
    // Write your solution here.
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  
  public Integer poll() {
    move();  //if out stack is empty, remove from in to out stack
    return out.isEmpty() ? null : out.pollFirst();
  }
  
  public void offer(int element) {  // push into the in stack
    in.offerFirst(element); 
  }
  
  public Integer peek() {
    move();
    return out.isEmpty() ? null : out.peekFirst();
  }
  
  public void move(){
    if(out.isEmpty()){
      while(!in.isEmpty()){
        out.offerFirst(in.pollFirst());
      }
    }  
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    return in.size() == 0 && out.size() == 0;
  }
}








