/*
Sort a linked list in O(nlogn) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5

time = O(nlogn)
space = O(n)  for the new list, merge sort
space = O(nlogn) quick sort
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// merge sort:
class Solution {
    // use merge sort with O(nlogn)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast =  head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        
        if (head1 != null) {
            cur.next = head1;
        } else if (head2 != null) {
            cur.next = head2;
        }
        
        return dummy.next;
    }
}



// quick sort:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // quick sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode dummyLeft = new ListNode(0), curLeft = dummyLeft;
        ListNode dummyRight = new ListNode(0), curRight = dummyRight;
        ListNode dummyMid = new ListNode(0), curMid = dummyMid;
        
        while (head != null) {
            if (head.val < mid.val) {
                curLeft.next = head;
                curLeft = curLeft.next;
            } else if (head.val > mid.val) {
                curRight.next = head;
                curRight = curRight.next;
            } else {
                curMid.next = head;
                curMid = curMid.next;
            }
            head = head.next;
        }
        
        curLeft.next = null;
        curRight.next = null;
        curMid.next = null;
        ListNode left = sortList(dummyLeft.next);
        ListNode right = sortList(dummyRight.next);
        
        return concat(left, dummyMid.next, right);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode concat(ListNode left, ListNode mid, ListNode right) {
        ListNode dummy = new ListNode(0); 
        ListNode cur = dummy;
        cur.next = left;
        cur = moveEnd(cur);
        
        cur.next = mid;
        cur = moveEnd(cur);
        
        cur.next = right;
        cur = moveEnd(cur);
        
        return dummy.next;
    }
    
    private ListNode moveEnd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
