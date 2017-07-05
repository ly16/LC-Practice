/*
Reverse a linked list from position m to n.

Notice
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head==null || m>=n){
            return head;
        }
        ListNode dummy= new ListNode(289);
        dummy.next=head;
        head=dummy;
        
        //stop at the node before mth, because of dummy
        for(int i=1;i<m;i++){
            if(head==null){
                return null;
            }
            head=head.next;
        }
        
        ListNode premNode=head;//the node before the mNode
        ListNode mNode=head.next;
        ListNode nNode=mNode, postnNode=nNode.next;
        for(int j=m; j<n; j++){
            if(postnNode==null){
                return null;
            }
            
            ListNode temp=postnNode.next;
            postnNode.next=nNode;
            nNode=postnNode;
            postnNode=temp;
        }
        mNode.next=postnNode;
        premNode.next=nNode;
        return dummy.next;
    }
}
