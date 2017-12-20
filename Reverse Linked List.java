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

time = O(n)
space = O(1)
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
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
