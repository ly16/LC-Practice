/*
Merge K sorted lists into one big sorted list in ascending order.

Assumptions
ListOfLists is not null, and none of the lists is null.

time = O(n*log(k)) n is the total number of nodes
space = O(k) for the heap
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


// method1: heap version
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


// method2: merge sort version
// time = O(nlogk) if large list is on the first place
// space = O(k)
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


// version 3: merge two by two
// time = O(nlogk), space = O(k)
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1) {
            List<ListNode> new_lists = new ArrayList<ListNode>();
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                ListNode merged_list = merge(lists.get(i), lists.get(i+1));
                new_lists.add(merged_list);
            }
            if (lists.size() % 2 == 1) {
                new_lists.add(lists.get(lists.size() - 1));
            }
            lists = new_lists;
        }
        
        return lists.get(0);
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
        
        return dummy.next;
    }
}
