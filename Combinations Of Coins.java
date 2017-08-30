/*
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
get all the possible ways to pay a target number of cents.

coins - an array of positive integers representing the different denominations of coins, 
there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99

coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.

Time = O(99/1 ^ n)
space = O(5) = O(n)
*/

public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here.
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(target, coins, 0, cur, result);
    return result;
  }
  
  
  // target: remain cents; coins: different types of coins;
  private void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
    // terminate
    if (index == coins.length - 1) {
      if (target % coins[coins.length - 1] == 0) {
        cur.add(target / coins[coins.length - 1]);
        result.add(new ArrayList<Integer>(cur));
        cur.remove(cur.size() - 1);
      }
      return;
    }
    
    int max = target / coins[index];
    for (int i = 0; i <= max; i++){
      cur.add(i);
      helper(target - i * coins[index], coins, index + 1, cur, result);
      cur.remove(cur.size() - 1);
    }
  }
}
