/*

Find all pairs of elements in a given array that sum to the pair the given target number. 
Return all the distinct pairs of values.

Assumptions
The given array is not null and has length of at least 2
The order of the values in the pair does not matter

Examples
A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

time = O(n)
space = O(n)  for a hashmap
*/



public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : array) {
    	Integer count = map.get(num);
      if (num * 2 == target && count != null && count == 1) {
      	result.add(Arrays.asList(num, num));
      } else if (map.containsKey(target - num) && count == null) {
      	result.add(Arrays.asList(target - num, num));
      }
      if (count == null) {
      	map.put(num, 1);
      } else {
      	map.put(num, count + 1);
      }
    }
    return result;
  }
}
