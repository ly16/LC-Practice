/*
Merge two sorted lists into one large sorted list.

L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
steps:
1 4 6
  o
2 5
t
dummy -> 1

1 4 6
  o
2 5
  t
dummy -> 1 -> 2

1 4 6
    o
2 5
  t
dummy -> 1 -> 2 -> 4

1 4 6
    o
2 5 null
    t
dummy -> 1 -> 2 -> 4 -> 5

one != null
dummy -> 1 -> 2 -> 4 -> 5 -> 6
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
  public ListNode merge(ListNode one, ListNode two) {
    // write your solution here
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;     // hold the head
    while(one !=null && two !=null){
      if(one.value <= two.value){
        cur.next = one;
        one = one.next;
      } else {
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    // If there are one of the ListNodes left
    if(one != null){
      cur.next = one;
    } else {
      cur.next =two;
    }
    return dummy.next;
  }
}
