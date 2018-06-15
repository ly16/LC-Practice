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

time = O(m+n)
space = O(1) only dummy node
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
    ListNode cur = dummy;
    while (one != null && two != null) {
      if (one.value <= two.value) {
        cur.next = one;
        one = one.next;
      } else {
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    
    if (one != null) {
      cur.next = one;
    } else {
      cur.next = two;
    }
    
    return dummy.next;
  }
}



// leetcode version
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        }
        
        if (l2 != null) {
            cur.next = l2;
        } 
        return dummy.next;
    }
}
