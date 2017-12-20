/*
Given a linked list and a target value T, partition it such that all nodes less than T are 
listed before the nodes larger than or equal to target value T. The original relative order
of the nodes in each of the two partitions should be preserved.

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
steps: target =3
2 4 3 5 1
s l l l s
small -> 2 ->1
large -> 4 -> 3 -> 5 
small -> 2 -> 1 -> 4 -> 3 -> 5 -> null

time = O(n)
space = O(n)
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
  public ListNode partition(ListNode head, int target) {
    // write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode smallHead = new ListNode(0);
    ListNode small = smallHead;
    ListNode LargeHead = new ListNode(0);
    ListNode large = LargeHead;
    
    while (head != null) {
      if (head.value < target) {
        small.next = head;
        small = small.next;
      } else {
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    
    small.next = LargeHead.next;
    large.next = null;
    return smallHead.next;
  }
}
