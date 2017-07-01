/*
Write code to remove duplicates from an unsorted linked list.

Example
Given 1->3->2->1->4.
Return 1->3->2->4
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        HashSet<Integer> hash= new HashSet<>();
        
        ListNode dummy= new ListNode(23);
        dummy.next=head;
        head=dummy;
        while(head.next!=null){
            if(hash.contains(head.next.val)){
                head.next= head.next.next;
            }else{
                hash.add(head.next.val);
                head=head.next;
            }
        }
        return dummy.next;
    }  
}
