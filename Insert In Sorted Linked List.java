/*
Insert a value in a sorted linked list.

L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
steps: value = 2
1 3 5
p.next > 2
1 2 3 5
*/



/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode insert(ListNode head, int value) {
    // write your solution here
    ListNode newNode = new ListNode(value);
    // 1. Value is less than the head value
    if(head == null || value < head.value){
      newNode.next = head;
      return newNode;
    }
    // 2. value insert in the middle
    ListNode prev = head;         //hold the head 
    while(prev.next != null && prev.next.value < value){
      prev = prev.next;
    }
    newNode.next = prev.next;
    prev.next = newNode;
    return head;
  }
}
