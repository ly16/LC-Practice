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
    if(head == null || head.next == null){
      return head;
    }
    ListNode small = new ListNode(0);
    ListNode large = new ListNode(0);
    // Hold the head
    ListNode curS = small;
    ListNode curL = large;
    while(head != null){
      if(head.value < target){
        curS.next = head;
        curS = curS.next;
      } else {
        curL.next = head;
        curL = curL.next;
      }
      head = head.next;
    }
    // connect the tail of small to the head of large
    curS.next = large.next;
    // avoid loop, put the tail of large to null
    curL.next = null;
    return small.next;
  }
}
