/*
Given a linked list, remove the nth node from the end of list and return its head.
Given linked list: 1->2->3->4->5->null, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5->null.
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(n<=0)
        {
            return null;
        }
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode preDelete=dummy;
        
        /*first point; when first pointor get Nth, the second starts
        to go. Whe the first pointor get the end, the second gets the 
        Nth from the end.*/
        for(int i=0;i<n;i++)
        {
            if(head==null)  //node=0
            {
                return null;
            }
            head=head.next; //node=1
        }
        // start the second
        while(head!= null)
        {
            head=head.next;
            preDelete=preDelete.next;
        }
        //after first pointor reaches the end
        preDelete.next=preDelete.next.next;
        return dummy.next;
    }
}
