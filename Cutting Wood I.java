/*
There is a wooden stick with length L >= 1, we need to cut it into pieces, 
where the cutting positions are defined in an int array A. The positions are guaranteed 
to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length 
of the stick segment being cut. Determine the minimum total cost to cut the stick into the defined pieces.

Examples
L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)

time = O(n^3)
space = O(n^2)
*/

public class Solution {
	public int minCost(int[] cuts, int length) {
        int[] helper = new int[cuts.length + 2];
        helper[0] = 0;
        for (int i = 1; i < cuts.length; i++) {
            helper[i + 1] = cuts[i];
        }
        helper[helper.length - 1] = length;
        // min cost of cutting (i, j)
        int[][] cost = new int[helper.length][helper.length];
        for (int i = 1; i < helper.length; i++) {
        	for (int j = i - 1; j >= 0; j--) {
          	if (j + 1 == i) {
            	cost[j][i] = 0;
            } else {
            	cost[j][i] = Integer.MAX_VALUE;
              for (int k = j + 1; k < i; k++) {
              	cost[j][i] = Math.min(cost[j][i], cost[j][k] + cost[k][i]);
              }
              cost[j][i] += helper[i] - helper[j];
            }
          }
        }
  			return cost[0][helper.length - 1];
    }
}
