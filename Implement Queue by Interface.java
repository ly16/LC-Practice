/*Implement queue by interface.*/
class Node {
    public int val;
    public Node next, prev;
    public Node(int val) {
        this.val = val;
        prev = next = null;
    }
}

interface InterfaceQueue {
    void push(int val);

    // define an interface for pop method
    /* write your code here */
    int pop();

    // define an interface for top method
    /* write your code here */
     int top();
}  

public class MyQueue implements InterfaceQueue {
    /* you can declare your private attributes here */
    private Node first, last;

    public MyQueue() {
       // do initialization if necessary
       
    }

    // implement the push method
    /* write your code here */
    @Override
    public void push(int val) {
        //if first is null, last must be null
        if (first == null) {
            first=last= new Node(val);
        } else {
            last.next = new Node(val);;
            last = last.next;
        }
    }
    
  

    @Override
     public int pop() {
        /* write your code here */
        //extract the first value and move forward
        if (first != null) {
            int result = first.val;
            first = first.next;
            return result;
        }
        return -1;
    }

    @Override
      public int top() {
        /* write your code here */
        if (first != null) {
            return first.val;
        }
        return -1;
    }

 
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue queue = new MyQueue();
 * queue.push(123);
 * queue.top(); will return 123;
 * queue.pop(); will return 123 and pop the first element in the queue
 */

