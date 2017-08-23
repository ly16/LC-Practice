/*
Enhance the stack implementation to support min() operation. 
min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1
push(int element) - push the element to top
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.

When you pop from stack, you should consider the minStack
You store for the min value, indcluding the same small ones, so the number of min elements should be the same
*/



public class Solution {
  private Deque<Integer> stack; //interface
    private Deque<Integer> minStack;
  
  public Solution() {
    // write your solution here
    stack = new LinkedList<Integer>();  //implement
    minStack = new LinkedList<Integer>();
  }
  
  public int min(){
    if(minStack.isEmpty()){
      return -1;
    }
    return minStack.peekFirst();
  }
  
  public void push(int element){
    stack.offerFirst(element);      // push the smaller one in the minStack
    if(minStack.isEmpty() || element <= minStack.peekFirst()){
      minStack.offerFirst(element);
    }
  }
  
  public int pop() {
    if(stack.isEmpty()){
      return -1;
    }
    Integer result = stack.pollFirst();
    if (minStack.peekFirst().equals(result)){
      minStack.pollFirst(); //since we push "<=" to the minStack
    }
    return result;
  }
  
  public int top(){
    if (stack.isEmpty()){
      return -1;
    }
    return stack.peekFirst();
  }
}
