/*
Given three arrays sorted in ascending order. 
Pull one number from each array to form a coordinate <x,y,z> in a 3D space. 
Find the coordinates of the points that is k-th closest to <0,0,0>.

We are using euclidean distance here.

Assumptions
The three given arrays are not null or empty
K >= 1 and K <= a.length b.length c.length
Return a size 3 integer list, the first element should be from the first array, 
the second element should be from the second array and the third should be from the third array

Examples
A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)

time = O(klogk) 
space = O(k) for minHeap and set
*/


public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    // Write your solution here
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>(){
    	@Override
      public int compare(List<Integer> l1, List<Integer> l2) {
      	long o1 = distance(l1, a, b, c);
        long o2 = distance(l2, a, b, c);
        if (o1 == o2) {
        	return 0;
        }
        return o1 < o2 ? -1 : 1;
      }
    });
    Set<List<Integer>> visited = new HashSet<>();
    List<Integer> cur = Arrays.asList(0, 0, 0);
    visited.add(cur);
    minHeap.offer(cur);
    while (k > 0) {
    	cur = minHeap.poll();
      List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if (next.get(0) < a.length && visited.add(next)) {
      	minHeap.offer(next);
      }
      next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if (next.get(1) < b.length && visited.add(next)) {
      	minHeap.offer(next);
      }
      next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if (next.get(2) < c.length && visited.add(next)) {
      	minHeap.offer(next);
      }
      k--;
    }
    cur.set(0, a[cur.get(0)]);
    cur.set(1, b[cur.get(1)]);
    cur.set(2, c[cur.get(2)]);
   	return cur;
  }
  
  private long distance (List<Integer> point, int[] a, int[] b, int[] c) {
  	long dist = 0;
    dist += a[point.get(0)] * a[point.get(0)];
    dist += b[point.get(1)] * b[point.get(1)];
    dist += c[point.get(2)] * c[point.get(2)];
		return dist;
  }
}
