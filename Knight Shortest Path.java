/*
Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) 
with a source position, find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.

Clarification
If the knight is at (x, y), he can get to the following positions in one step:
(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)

Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1

time = O(mn)
space = O(mn) for the queue
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    int n, m; // size of the chessboard
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // time = O(mn)
        // space = O()
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int step = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (cur.x == destination.x && cur.y == destination.y) {
                    return step;
                }
                for (int dir = 0; dir < 8; dir++) {
                    Point next = new Point(cur.x + deltaX[dir], cur.y + deltaY[dir]);
                    if (!valid(grid, next)) {
                        continue;
                    }
                    queue.offer(next);
                    grid[next.x][next.y] = true;
                }
            }
            step++;
        }
        return -1;
    }
    
    private boolean valid(boolean[][] grid, Point next) {
        if (next.x < 0 || next.x >= grid.length) {
            return false;
        }
        if (next.y < 0 || next.y >= grid[0].length) {
            return false;
        }
        return (!grid[next.x][next.y]);
    }
}
