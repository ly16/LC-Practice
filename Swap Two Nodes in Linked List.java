/*
Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. 
It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, 
do nothing.

Notice
You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.

Example
Given 1->2->3->4->null and v1 = 2, v2 = 4.
Return 1->4->3->2->null.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        //find previous nodes for v1, v2
        ListNode node1Prev = null, node2Prev = null;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }
        
        if (node1Prev == null || node2Prev == null) {
            return head;
        }
        
        //make sure n1 != n2.next
        if (node2Prev.next == node1Prev) {
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }
        // n1 is previous to n2
        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;
            node2Prev.next = node1;
            node1.next = node2Next;
        }
        
        return dummy.next;

    }
}
