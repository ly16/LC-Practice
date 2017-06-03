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
