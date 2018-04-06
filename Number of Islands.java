/*
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. 
We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Given graph:
[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

time = O(mn)
space = O(mn)
*/

public class Solution {
    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    BFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void BFS(boolean[][] grid, int x, int y) {
        int[] deltaX = new int[] {1, 0, -1, 0};
        int[] deltaY = new int[] {0, 1, 0, -1};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;
        
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate next = new Coordinate(cur.x + deltaX[i], cur.y + deltaY[i]);
                if (!valid(next, grid)) {
                    continue;
                }
                grid[next.x][next.y] = false;
                queue.offer(next);
            }
        }
    }
    
    private boolean valid(Coordinate next, boolean[][] grid) {
        if (next.x < 0 || next.x >= grid.length) {
            return false;
        }   
        if (next.y < 0 || next.y >= grid[0].length) {
            return false;
        }
        return grid[next.x][next.y];
    }
}
