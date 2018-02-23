/*
Given a gym with k pieces of equipment and some obstacles.  
We bought a chair and wanted to put this chair into the gym such that  
the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. 
The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle, 
'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) 
if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. 
You can not put the chair on a cell with equipment or obstacle.

Assumptions
There is at least one equipment in the gym
The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
It is guaranteed that each 'C' cell is reachable from all 'E' cells.
If there does not exist such place to put the chair, just return null (Java) empty vector (C++)

Examples
{ { 'E', 'O', 'C' },

  {  'C', 'E',  'C' },

  {  'C',  'C',  'C' } }
we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.


time = O(mn * log(mn))
space = O(mn) for cost/visited matrix
*/



public class Solution {
  private static final char equip = 'E';
  private static final char ob = 'O';
  static class Pair {
  	int i;
    int j;
    Pair(int i, int j) {
    	this.i = i;
      this.j = j;
    }
  }
  
  public List<Integer> putChair(char[][] gym) {
    // Write your solution here.
    int m = gym.length;
    int n = gym[0].length;
    int[][] cost = new int[m][n];
    for (int i = 0; i < m; i++) {
    	for (int j = 0; j < n; j++) {
      	if (gym[i][j] == equip) {
        	if (!addCost(gym, cost, i, j)) {
          	return null;
          }
        }
      }
    }
    List<Integer> result = null;
    for (int i = 0; i < m; i++) {
    	for (int j = 0; j < n; j++) {
      	if (gym[i][j] != equip && gym[i][j] != ob) {
        	if (result == null) {
          	result = Arrays.asList(i, j);
          } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
          	result.set(0, i);
            result.set(1, j);
          }
        }
      }
    }
    return result;
  }
  
  private boolean addCost(char[][] gym, int[][] cost, int i, int j) {
  	boolean[][] visited = new int[gym.length][gym[0].length];
    Queue<Pair> queue = new LinkedList<>();
    visited[i][j] = true;
    queue.offer(new pair(i, j));
    pathCost = 1;
    while (!queue.isEmpty()) {
    	int size = queue.size();
      Pair cur = queue.poll();
      for (int l = 0; l < size; l++) {
      	List<Pair> neis = getNeis(cur, gym);
        for (Pair nei : neis) {
        	if (!visited[nei.i][nei.j]) {
          	visited[nei.i][nei.j] = true;
            queue.offer(nei);
            cost[nei.i][nei.j] += pathCost;
          }
        }
      }
      pathCost++;
    }
    for (int l = 0; l < gym.length; l++) {
    	for (int m = 0; m < gym[0].length; m++) {
      	if (!visited[l][m] && gym[l][m] == equip) {
        	return false;
        }
      }
    }
    return true;
  }
  
  private List<Pair> getNeis(Pair cur, char[][] gym) {
    List<Pair> neis = new ArrayList<>();
    int x = cur.i;
    int y = cur.j;
    int m = gym.length;
    int n = gym[0].length;
    
    if (x + 1 < m && gym[x + 1][y] != ob) {
    	neis.add(new Pair(x + 1, y));
    }
    if (y + 1 < n && gym[x][y + 1] != ob) {
    	neis.add(new Pair(x, y + 1));
    }
    if (x - 1 >= 0 && gym[x - 1][y] != ob) {
    	neis.add(new Pair(x - 1, y));
    }
    if (y - 1 >= 0 && gym[x][y - 1] != ob) {
    	neis.add(new Pair(x, y - 1));
    }
    return neis;
  }
}
