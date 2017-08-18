/*
Reverse a singly-linked list.
L = 1 -> null, return 1 -> null
setps:
1 -> null
prev = null
next = null
head = 1
// move forward
prev = 1
head = null
return prev = 1
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
  public ListNode reverse(ListNode head) {
    // write your solution here
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;  // hold next head
      head.next = prev; //reverse
      prev = head;  // move forward
      head = next;
    }
    return prev;
  }
}
