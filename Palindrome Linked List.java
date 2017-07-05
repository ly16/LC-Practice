/*
Implement a function to check if a linked list is a palindrome.
Example
Given 1->2->1, return true
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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head==null){
            return true;
        }
        ListNode middle= findMid(head);
        middle.next=reverse(middle.next);
        
        ListNode p1=head, p2=middle.next;
        while(p1!=null && p2!=null && p1.val==p2.val){
            p1= p1.next;
            p2= p2.next;
        }
        return p2==null;
    }
    
    private ListNode findMid(ListNode head){
        if(head==null){
            return null;
        }
        ListNode slow= head, fast= head.next;
        while(fast!= null && fast.next!= null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    
    // reverse after middle node 1234321->1234123
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev= head;
            head= temp;
        }
        return prev;
    }
}
