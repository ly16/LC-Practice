/*
Insert a node in a sorted linked list.
Given list = 1->4->6->8 and val = 5.
Return 1->4->5->6->8.
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @param val: an integer
     * @return: The head of new linked list
     */
    public ListNode insertNode(ListNode head, int val) { 
        // Write your code here
        ListNode node= new ListNode(val);
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;
        while(head.next!=null && head.next.val<=val)
        {
            head=head.next;
        }
        node.next=head.next;//insert node val
        head.next=node;
        
        return dummy.next;// the head of new linked list
    }  
}
