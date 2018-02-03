/*
Merge K sorted lists into one big sorted list in ascending order.

Assumptions
ListOfLists is not null, and none of the lists is null.

time = O(kn*log(k))
space = O(k)
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
  public ListNode merge(List<ListNode> listOfLists) {
    // Write your solution here
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new MyComparator());
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (ListNode node : listOfLists) {
    	if (node != null) {
      	minHeap.offer(node);
      }
    }
    while (!minHeap.isEmpty()) {
    	cur.next = minHeap.poll();
      if (cur.next.next != null) {
      	minHeap.offer(cur.next.next);
      }
      cur = cur.next;
    }
    return dummy.next;
  }

  static class MyComparator implements Comparator<ListNode> {
  	@Override
    public int compare (ListNode l1, ListNode l2) {
    	if (l1.value == l2.value) {
      	return 0;
      }
      return l1.value < l2.value ? -1 : 1;
    }
  }
  
}
