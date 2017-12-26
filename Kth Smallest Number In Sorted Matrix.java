/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, 
and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
time = O(klogk) kth smallest
space = O(k)  //extra minheap
*/


public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here.
    int rows = matrix.length;
    int cols = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
      @Override
      public int compare(Cell o1, Cell o2) {
        if (o1.value == o2.value) {
          return 0;
        }
        return o1.value < o2.value ? -1 : 1;
      }
    });
    boolean[][] visited = new boolean[rows][cols];
    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    
    for(int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
        minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
        minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    
    return minHeap.peek().value;
  }
  
  static class Cell{
    int row;
    int col;
    int value;
    
    Cell(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
  }
}
