/*
Description
Merge two sorted (ascending) lists of interval and return it as a new sorted list. 
The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.

Example
Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].

time = O(m+n)
space = O(1)
*/


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> results = new ArrayList<>();
        if (list1 == null || list2 == null) {
            return results;
        }
        
        Interval last = null, curt = null;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                curt = list1.get(i++);
            } else {
                curt = list2.get(j++);
            }
            
            last = merge(results, last, curt);
        }
        
        while (i < list1.size()) {
            last = merge(results, last, list1.get(i++));
        }
        
        while (j < list2.size()) {
            last = merge(results, last, list2.get(j++));
        }
        
        if (last != null) {
            results.add(last);
        }
        return results;
    }
    
    private Interval merge(List<Interval> results, Interval last, Interval curt) {
        if (last == null) {
            return curt;
        }
        
        if (curt.start > last.end) {
            results.add(last);
            return curt;
        }
        
        last.end = Math.max(last.end, curt.end);
        return last;
    }
}
