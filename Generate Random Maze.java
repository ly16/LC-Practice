/*
Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell. 
For each pair of cells on the corridor, there must exist one and only one path between them. 
(Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.). 
The wall is denoted by 1 in the matrix and corridor is denoted by 0.

Assumptions
N = 2K + 1 and K >= 0
the top left corner must be corridor
there should be as many corridor cells as possible
for each pair of cells on the corridor, there must exist one and only one path between them

Examples
N = 5, one possible maze generated is

        0  0  0  1  0

        1  1  0  1  0

        0  1  0  0  0

        0  1  1  1  0

        0  0  0  0  0

time = O(n^2)
space = O(n^2)
*/


public class Solution {
  enum Dir {
  	north(1,0), south(-1, 0), west(0, 1), east(0, -1);
    int deltaX, deltaY;
    Dir(int deltaX, int deltaY) {
    	this.deltaX = deltaX;
      this.deltaY = deltaY;
    }
    public int moveX(int x, int times) {
    	return x + deltaX * times;
    }
    public int moveY(int y, int times) {
    	return y + times * deltaY;
    }
  }
  
  public int[][] maze(int n) {
    // initialization
    int[][] maze = new int[n][n];
    for (int i = 0; i < maze.length; i++) {
    	for (int j = 0; j < maze[0].length; j++) {
      	if (i == 0 && j == 0) {
        	maze[i][j] = 0;
        } else {
        	maze[i][j] = 1;
        }
      }
    }
    generate(maze, 0, 0);
    return maze;
  }
  
  private void generate(int[][] maze, int x, int y) {
  	Dir[] dirs = Dir.values();
    shuffle(dirs);
    for (Dir dir : dirs) {
    	int nextX = dir.moveX(x, 2);
      int nextY = dir.moveY(y, 2);
      if (isValid(maze, nextX, nextY)) {
        maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
        maze[nextX][nextY] = 0;
        generate(maze, nextX, nextY);
      }
    }
  }
  
  private void shuffle(Dir[] dirs) {
  	for (int i = 0; i < dirs.length; i++) {
    	int change = (int) (Math.random() * (dirs.length - i));
      Dir tmp = dirs[change + i];
      dirs[change + i] = dirs[i];
      dirs[i] = tmp;
    }
  }
  
  private boolean isValid(int[][] maze, int x, int y) {
    return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
  }
}
