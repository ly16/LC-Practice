/*
We have a list of piles of stones, each pile of stones has a certain weight, 
represented by an array of integers. In each move, we can merge two adjacent piles into one larger pile, 
the cost is the sum of the weights of the two piles. We merge the piles of stones until we have only one pile left.
Determine the minimum total cost.

Assumptions
stones is not null and is length of at least 1

Examples
{4, 3, 3, 4}, the minimum cost is 28
merge first 4 and first 3, cost 7
merge second 3 and second 4, cost 7
merge two 7s, cost 14
total cost = 7 + 7 + 14 = 28

time = O(n^3)
space = O(n^2)
*/


public class Solution {
  public int minCost(int[] stones) {
    // Write your solution here
    int len = stones.length;
    int[][] subSum = new int[len][len];
    int[][] cost = new int[len][len];
    for (int i = 0; i < len; i++) {
    	for (int j = i; j >= 0; j--) {
      	if (i == j) {
        	cost[j][i] = 0;
          subSum[j][i] = stones[i];
        } else {
        	subSum[j][i] = subSum[j][i - 1] + stones[i];
          cost[j][i] = Integer.MAX_VALUE;
          for (int k = j; k < i; k++) {
          	cost[j][i] = Math.min(cost[j][i], cost[j][k] + cost[k + 1][i]) ;
          }
          cost[j][i] += subSum[j][i];
        }
      }
    }
    return cost[0][len - 1];
  }
}
