/*

Given a matrix of size N x M. For each row the elements are sorted in ascending order, 
and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
time = O(klogk) kth smallest
*/

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here.
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    // Best First Seach, minHeap, definition
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2){
        if (c1.value == c2.value){
          return 0;
        }
        return c1.value < c2.value ? -1 : 1;
      }
    });
    
    // generated to be true
    boolean[][] visited = new boolean[rows][cols];
    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    
    // Best First Search
    for(int i = 0; i< k - 1; i++){  // poll k-1 elemets smaller, peek kth 
      Cell cur = minHeap.poll();    
      // not boundary or generated before
      // check row
      if(cur.row + 1 < rows && !visited[cur.row + 1][cur.column]){
      minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
      visited[cur.row + 1][cur.column] = true;
      }
      // check column
      if(cur.column + 1 < cols && !visited[cur.row][cur.column + 1]){
      minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
      visited[cur.row][cur.column + 1] = true;
      }
    }
    return minHeap.peek().value;
  }
  
  static class Cell{
    int row;
    int column;
    int value;
    
    Cell(int row, int column, int value){
      this.row = row;
      this.column = column; 
      this.value = value;
    }
  }
}
