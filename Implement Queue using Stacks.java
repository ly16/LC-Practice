/*
Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Example:
MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, 
and is empty operations are valid.
Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

time = push O(1), pop,peek O(n), empty O(1)
space = O(1)
*/

class MyQueue {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void stack2To1() {
        while (!stack2.isEmpty()) {
            stack1.offerFirst(stack2.pollFirst());
        }
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack2.offerFirst(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.isEmpty()) {
            stack2To1();
        }
        int element = stack1.pollFirst();
        return element;
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack1.isEmpty()) {
            stack2To1();
        }
        int element = stack1.peekFirst();
        return element;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.size() == 0 && stack2.size() == 0) {
            return true;
        } 
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
