/*
Enhance the stack implementation to support min() operation. 
min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1
push(int element) - push the element to top
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.

When you pop from stack, you should consider the minStack
You store for the min value, indcluding the same small ones, so the number of min elements should be the same

time = O(1)
space = O(n)
*/

public class Solution {
  private Deque<Integer> stack;
  private Deque<Integer> minStack;
  public Solution() {
    // write your solution here
    stack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    Integer result = stack.pollFirst();
    if (result.equals(minStack.peekFirst())) {
      minStack.pollFirst();
    }
    return result;
  }
  
  public void push(int element) {
    stack.offerFirst(element);
    if (minStack.isEmpty() || minStack.peekFirst() >= element) {
      minStack.offerFirst(element);
    }
  }
  
  public int top() {
    return stack.isEmpty() ? -1 : stack.peekFirst();
  }
  
  public int min() {
    return stack.isEmpty() ? -1 : minStack.peekFirst();
  }
}

