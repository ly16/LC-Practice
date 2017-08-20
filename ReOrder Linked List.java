/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
steps:
1 2 3 4
  m
one: 1  2
two: 3  4
reverse two: 4  3
merge: 1 4 2 3
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
  public ListNode reorder(ListNode head) {
    // Write your solution here.
    if(head == null || head.next == null){
      return head;
    }
    // 1. find the middle
    ListNode mid = midNode(head);
    ListNode one = head;                // first half
    ListNode two = mid.next;             // second half
    // 2. Seperate two halfs
    mid.next = null;
    // 3. reverse the second half and merge together
    return merge(one, reverse(two));
  }
  // 1. find the middle
  private ListNode midNode(ListNode head){      //corner case before
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  // 3. reverse the second half and merge together
  private ListNode reverse(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
  
  private ListNode merge(ListNode one, ListNode two){
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(one != null && two != null){
      cur.next = one;
      one = one.next;
      cur.next.next = two;
      two = two.next;
      cur = cur.next.next;
    }
    if(one != null){
      cur.next = one;
    } else {
      cur.next = two;
    }
    return dummy.next;
  }
}



