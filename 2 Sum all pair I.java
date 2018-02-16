/*
Find all pairs of elements in a given array that sum to the given target number. 
Return all the pairs of indices.

Assumptions
The given array is not null and has length of at least 2.

Examples
A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]


time = O(n^2)
space = O(n) for a hashmap
*/

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
    	List<Integer> index = map.get(target - array[i]);
      if (index != null) {
      	for (int j : index) {
        	result.add(Arrays.asList(j, i));
        }
      }
      if (!map.containsKey(array[i])) {
      	map.put(array[i], new ArrayList());
      }
      map.get(array[i]).add(i);
    }
    return result;
  }
}
