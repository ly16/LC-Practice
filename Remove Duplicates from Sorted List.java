/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head==null){
            return null;
        }
        ListNode p=head;
        while(p.next!=null){
            if(p.val==p.next.val){
                p.next=p.next.next;
            }else{
                 p=p.next;
            }
        }
       return head;
    }  
}


// leetcode version
// time = O(n), space = O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast.val == slow.val) {
                slow.next = fast.next;
                fast.next = fast.next.next;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
}
