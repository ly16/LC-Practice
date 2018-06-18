/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1

time = O(nlogn) for sort
space = O(n) for heap
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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval o1, Interval o2) {
               return o1.start - o2.start;
           } 
        });
        
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval item = minHeap.poll();
            if (intervals[i].start >= item.end) {
                // merge two ranges with no intersection
                item.end = intervals[i].end;
            } else {
                minHeap.offer(intervals[i]);
            }
            // put back the merged interval
            minHeap.offer(item);
        }
        return minHeap.size();
    }
}
