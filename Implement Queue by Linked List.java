/*
Implement a Queue by linked list. Support the following basic methods:

enqueue(item). Put a new item in the queue.
dequeue(). Move the first item out of the queue, return it.

enqueue(1)
enqueue(2)
enqueue(3)
dequeue() // return 1
enqueue(4)
dequeue() // return 2
*/

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
        next = null;
    }
}

public class MyQueue {
    public Node first, last;
    
    public MyQueue() {
        // do initialize if necessary
        first=last=null;
    }

    public void enqueue(int item) {
        // Write your code here
        if(first==null){
            first=last=new Node(item);
        }else{
            last.next=new Node(item);
            last=last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        if(first!=null){
            int result=first.val;
            first=first.next;
            return result;
        }
        return -1;
    }
}
