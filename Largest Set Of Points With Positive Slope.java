/*
Given an array of 2D coordinates of points (all the coordinates are integers), 
find the largest number of points that can form a set such that any pair of points 
in the set can form a line with positive slope. Return the size of such a maximal set.

Assumptions
The given array is not null
Note: if there does not even exist 2 points can form a line with positive slope, should return 0.

Examples
<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.

time = O(n^2)
space = O(n) for the int[]
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
  public int largest(Point[] points) {
    // Write your solution here.
    Arrays.sort(points, new MyComparator());
    int[] longest = new int[points.length];
    int result = 0;
    for (int i = 0; i < points.length; i++) {
    	for (int j = 0; j < i; j++) {
      	if (points[j].y < points[i].y && points[j].x < points[i].x) {
        	longest[i] = Math.max(longest[i], longest[j]);
        } 
      }
      longest[i]++;
      result = Math.max(longest[i], result);
    }
    return result == 1 ? 0 : result;
  }
  
  static class MyComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
    	if (o1.y < o2.y) {
      	return -1;
      } else if (o1.y > o2.y) {
      	return 1;
      } else if (o1.x < o2.x) {
      	return -1;
      } else if (o1.x > o2.x) {
      	return 1;
      } else {
      	return 0;
      }
    }
  }
}

