/*
Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1

time = O(1)
space = O(n) for the stack
*/
public class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack=new Stack<Integer>();
        minStack= new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
         if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}



// leetcode version
class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.offerFirst(x);
        if (minStack.isEmpty()) {
            minStack.offerFirst(x);
        } else {
            minStack.offerFirst(Math.min(x, minStack.peekFirst()));
        }
    }
    
    public void pop() {
        minStack.pollFirst();
        stack.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
