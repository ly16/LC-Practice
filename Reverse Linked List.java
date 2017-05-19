/*
Reverse a linked list.
For linked list 1->2->3, the reversed linked list is 3->2->1
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode rev=null;              //initialize reversal linked list
        while(head !=null)
        {
            ListNode newHead=head.next;  //find the new head for next linkedlist
            head.next=rev;              //put the head.next to reverse list
            rev=head;                   //put the head to reverse list
            head=newHead;               //set the new head for next linkedlist
        }
        return rev;
    }
}
