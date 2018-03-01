/*
Given a stream of characters, find the first non-repeating character from stream. 
You need to tell the first non-repeating character in O(1) time at any moment.

Implement two methods of the class:
read() - read one character from the stream
firstNonRepeating() - return the first non-repoeating character from the stream at any time when calling the method, 
return null if there does not exist such characters

Examples:
read:
a   b   c   a   c   c    b
firstNonRepeating:
a   a   a   b   b   b   null


time = O(1)
space = O(n)
*/

public class Solution {
  static class Node {
  	Node prev;
    Node next;
    Character ch;
    Node(Character ch) {
    	this.ch = ch;
    }
  }
  
  private Node head;
  private Node tail;
  private Map<Character, Node> singled;
  private Set<Character> repeated; 
  
  public Solution() {
    // Initialize the class.
    // sentinel
    tail = new Node(null);
    tail.prev = tail.next = null;
    head = tail;
    singled = new HashMap<Character, Node>();
    repeated = new HashSet<Character>();
  }
  
  public void read(char ch) {
    // Implement this method here.
    if (repeated.contains(ch)) {
    	return;
    }
    Node node = singled.get(ch);
    if (node == null) {
    	node = new Node(ch);
      // append to list and add to map
      append(node);
    } else {
      // remove from map and list and add to set
    	remove(node);
    }
  }
  
  private void append(Node node) {
    singled.put(node.ch, node);
    tail.next = node;
    node.prev = tail;
    node.next = head;
    tail = tail.next;
  }
  
  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    if (node == tail) {
    	tail = node.prev;
    }
  	singled.remove(node.ch);
    node.prev = node.next = null;
    repeated.add(node.ch);
  }
  public Character firstNonRepeating() {
    // only setinel left
    if (head == tail) {
    	return null;
    }
    return head.next.ch;
  }
}
