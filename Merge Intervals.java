/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

time = O(nlogn) for the sort
space = O(n)
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparactor());
        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                result.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end);
            }
        }
        return result;
    }
    
    // only sort the start part
    private class IntervalComparactor implements Comparator<Interval> {
        public int compare(Interval o1, Interval o2) {
            if (o1.start == o2.start) {
                return 0;
            } 
            return o1.start < o2.start ? -1 : 1;
        }
    }
}
