/*
Remove all elements from a linked list of integers that have value val.
Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
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
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;
        
        while(head.next!=null)
        {
            if(head.next.val!=val)
            {
               head=head.next;        //move heaad
            }else{
            head.next=head.next.next;   //remove val
            }
        }
        return dummy.next;
    }
}
