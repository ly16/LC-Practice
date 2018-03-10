/*
Given an array of 2D coordinates of points (all the coordinates are integers), 
find the largest number of points that can be crossed by a single line in 2D space.

Assumptions
The given array is not null and it has at least 2 points

Examples
<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)

time = O(n^2)
space = O(n) for the hashMap
*/


/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int most(Point[] points) {
    // Write your solution here.
    int result = 0;
    for (int i = 0; i < points.length; i++) {
    	Point seed = points[i];
      int same = 1;
      int sameX = 0;
      int most = 0;
      Map<Double, Integer> slopeMap = new HashMap<>();
      
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
        	continue;
        }
        Point tmp = points[j];
        if (tmp.x == seed.x && tmp.y == seed.y) {
        	same++;
        } else if (tmp.x == seed.x) {
        	sameX++;
        } else {
        	double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
          if (!slopeMap.containsKey(slope)) {
          	slopeMap.put(slope, 1);
          } else {
          	slopeMap.put(slope, slopeMap.get(slope) + 1);
          }
          most = Math.max(slopeMap.get(slope), most);
        }
      }
      most = Math.max(most, sameX) + same;
      result = Math.max(result, most);
    }
    return result;
  }
}
