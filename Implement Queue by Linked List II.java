/*
Implement a Queue by linked list. Provide the following basic methods:

push_front(item). Add a new item to the front of queue.
push_back(item). Add a new item to the back of the queue.
pop_front(). Move the first item out of the queue, return it.
pop_back(). Move the last item out of the queue, return it.

push_front(1)
push_back(2)
pop_back() // return 2
pop_back() // return 1
push_back(3)
push_back(4)
pop_front() // return 3
pop_front() // return 4

*/

class Node {
    public int val;
    public Node next, prev;
    public Node(int val) {
        this.val = val;
        prev = next = null;
    }
}

public class Dequeue {
    public Node first,last;
    
    public Dequeue() {
        // do initialize if necessary
        first=last=null;
    }

    public void push_front(int item) {
        // Write your code here
        if (first == null) {
            first=last = new Node(item);
        } else {
            Node tmp = new Node(item);
            first.prev = tmp;
            tmp.next = first;
            first = first.prev;
        }
    }

    public void push_back(int item) {
        // Write your code here
        if(first==null){
            first=last=new Node(item);
        }else{
            Node temp=new Node(item);
            last.next=temp;
            temp.prev=last;
            last=last.next;
        }
    }

    public int pop_front() {
        // Write your code here
        if(first!=null){
            int result=first.val;
            first=first.next;
            if(first!=null){
                first.prev=null;
            }else{
                last=null;
            }
            return result;
        }
        return -1;
    }
    

    public int pop_back() {
        // Write your code here
        if(last!=null){
            int result=last.val;
            last=last.prev;
            if(last!=null){
                last.next=null;
            }else{
                first=null;
            }
            return result;
        }
        return -1;
    }
}
