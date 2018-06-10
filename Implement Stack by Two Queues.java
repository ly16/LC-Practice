/*
Implement a stack by two queues. The queue is first in first out (FIFO). 
That means you can not directly pop the last element in a queue.

push(1)
pop()
push(2)
isEmpty() // return false
top() // return 2
pop()
isEmpty() // return true

time = push O(1), top/pop O(n)
space = O(1)
*/

class Stack {
    public Queue <Integer> queue1;
    public Queue <Integer> queue2;
    
    public Stack(){
        queue1= new LinkedList<Integer>();
        queue2= new LinkedList<Integer>();
    }
    
    public void moveItems(){
        while(queue1.size()!=1){
            queue2.offer(queue1.poll());
        }
    }
    
    public void swapQueues(){
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }
    
    
    public void push(int x) {
        // Write your code here
        queue1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        moveItems();
        queue1.poll();
        swapQueues();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        moveItems();
        int last=queue1.poll();
        swapQueues();
        queue1.offer(last);
        return last;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return queue1.isEmpty();
    }    
}


// leetcode version
class MyStack {

    /** Initialize your data structure here. */
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int element = queue1.poll();
        Queue<Integer> tmp = queue2;
        queue2 = queue1;
        queue1 = tmp;
        return element;
    }
    
    /** Get the top element. */
    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int element = queue1.poll();
        Queue<Integer> tmp = queue2;
        queue2 = queue1;
        queue1 = tmp;
        queue1.offer(element);
        return element;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
