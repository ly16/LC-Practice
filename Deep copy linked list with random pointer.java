/*
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. 
Make a deep copy of the original list.

time = O(n)
space = O(n)    hashmap to avoid duplication
*/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Write your solution here
    if (head == null) {
    	return head;
    }
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cur = dummy;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    while (head != null) {
    	if (!map.containsKey(head)) {
        map.put(head, new RandomListNode(head.value));
      }
      cur.next = map.get(head);
      if (head.random != null) {
      	if (!map.containsKey(head.random)) {
        	map.put(head.random, new RandomListNode(head.random.value));
        }
        cur.next.random = map.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
