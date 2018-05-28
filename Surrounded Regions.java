/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X

Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.

time = O(mn)
space = O(mn) for the queue
*/

class Solution {
    private int[] deltaX = new int[] {1, 0, -1, 0};
    private int[] deltaY = new int[] {0, 1, 0, -1};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        
        // boundary left to right
        for (int i = 0; i < n; i++) {
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }
        // boundary up to down
        for (int i = 0; i < m; i++) {
            bfs(board, 0, i);
            bfs(board, n - 1, i);
        }
        // check the boundary
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    
    private void bfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O') {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(x);
        qy.offer(y);
        board[x][y] ='W';
        while (!qx.isEmpty()) {
            int curX = qx.poll();
            int curY = qy.poll();
            
            // delta
            for (int i = 0; i < 4; i++) {
                int newX = curX + deltaX[i];
                int newY = curY + deltaY[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && board[newX][newY] == 'O') {
                    board[newX][newY] = 'W';
                    qx.offer(newX);
                    qy.offer(newY);
                }
            }
        }
    }
}
