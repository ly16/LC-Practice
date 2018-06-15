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


// method2: merge in order
// time = O(nklogk)
// space = O(logk)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode start = merge(lists, left, mid);
        ListNode end = merge(lists, mid + 1, right);
        return mergeTwoLists(start, end);
        
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }
        
        return dummy.next;
    }
}
