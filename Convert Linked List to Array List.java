/*
Convert a linked list to an array list.
Given 1->2->3->null, return [1,2,3].
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
     * @param head the head of linked list.
     * @return an array list
     */
    public List<Integer> toArrayList(ListNode head) {  
        // Write your code here
        List<Integer> array= new ArrayList<Integer>();
        while(head !=null)
        {
            array.add(head.val);
            head=head.next;
        }
        return array;
    }
}
