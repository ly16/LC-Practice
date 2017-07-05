/*
Given a linked list, swap every two adjacent nodes and return its head.
Example
Given 1->2->3->4, you should return the list as 2->1->4->3
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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode dummy= new ListNode(98);
        dummy.next=head;
        head=dummy;

        while(head.next!=null && head.next.next!=null){
            ListNode p1=head.next;
            ListNode p2=head.next.next;
            //swap p1 and p2
            head.next=p2;
            p1.next=p2.next;
            p2.next=p1;
            //loop
            head=p1;
        }
        return dummy.next;
    }
}
