/*
Convert an array list to a linked list.
Example
Given [1,2,3,4], return 1->2->3->4->null.
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
     * @param nums an integer array list
     * @return the first node of linked list
     */
    public ListNode toLinkedList(ArrayList<Integer> nums) {  
        // Write your code here
        if(nums.size()==0){
            return null;
        }
        ListNode head=null, p=null;
        // for(int i=0;i<nums.size(); i++){
        //     if(head==null){
        //         head=new ListNode(nums.get(i));
        //         p=head;
        //     }else{
        //         p.next=new ListNode(nums.get(i));
        //         p=p.next;
        //     }
        // }
        for(int item: nums){
            if(head==null){
                head=new ListNode(item);
                p=head;
            }else{
                p.next=new ListNode(item);
                p=p.next;
            }
        }
        return head;
    }
}
