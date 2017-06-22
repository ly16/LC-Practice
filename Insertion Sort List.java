/*
Sort a linked list using insertion sort.
Example
Given 1->3->2->0->null, return 0->1->2->3->null.
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
       ListNode sentinel = new ListNode(0);
       while(head!=null){
           ListNode cur = sentinel;
           while(cur.next!=null && cur.next.val < head.val){
               cur=cur.next;
           }
           // swap orders
           ListNode t= head.next;
           head.next= cur.next;
           cur.next= head;
           head=t;
       }
       return sentinel.next;
    }
}
