/*
Given a collection of intervals, merge all overlapping intervals.
Example
Given intervals => merged intervals:

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]
*/
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        //sort intervals
        Collections.sort(intervals, new IntervalComparator());
        //add merged intervals
        List<Interval> result= new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for(int i=1; i<intervals.size();i++){
            Interval curt= intervals.get(i);
            if(curt.start<= last.end){
                last.end=Math.max(curt.end, last.end);
            }else{
                result.add(last);
                last=curt;
            }
        }
        result.add(last);
        return result;
    }
    
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start-b.start;
        }
    }
}

