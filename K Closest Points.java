/*
Description
Given some points and a point origin in two dimensional space, 
find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, 
sorted by x-axis, otherwise sorted by y-axis.

Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]

time = O(nlogk)
space = O(k) for the maxHeap
*/


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        Point[] ret = new Point[k];
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                int disA = getDistance(a, origin);
                int disB = getDistance(b, origin);
                if (disA == disB && a.x == b.x) {
                    return a.y > b.y ? -1 : 1;
                } else if (disA == disB && a.y == b.y) {
                    return a.x > b.x ? -1 : 1;
                }
                return disA > disB ? -1 : 1;
            }
        });

        for (int i = 0; i < points.length; i++) {
            maxHeap.offer(points[i]);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
       
        while (!maxHeap.isEmpty())
            ret[--k] = maxHeap.poll();
        return ret;
    }
    
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
