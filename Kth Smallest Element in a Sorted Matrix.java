/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.


time = O(klogn) poll for k times
space = O(n)
*/

class Solution {
    class Tuple {
        int x;
        int y;
        int val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // best first search
        int rows = matrix.length;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });
        // offer the first column and generate smaller row value
        for (int i = 0; i < rows; i++) {
            minHeap.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int j = 0; j < k - 1; j++) {
            Tuple t = minHeap.poll();
            if (t.x == rows - 1) {
                continue;
            }
            minHeap.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return minHeap.poll().val;
    }
}
