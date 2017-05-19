/*
Find a node with given value in a linked list. Return null if not exists.
Given 1->2->3 and value = 3, return the last node.
Given 1->2->3 and value = 4, return null.
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
     * @param head: the head of linked list.
     * @param val: an integer
     * @return: a linked node or null
     */
    public ListNode findNode(ListNode head, int val) { 
        // Write your code here
        for(ListNode node=head; node !=null; node=node.next)
        {
            if(node.val==val)
            {return node;}
        }
        return null;
    }  
   
} 
