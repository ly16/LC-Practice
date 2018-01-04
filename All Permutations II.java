/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []

time = O(n!)
space = O(n)
*/

public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    helper(array, 0, result);
    return result;
  }
  
  public void helper(char[] array, int index, List<String> result) {
    if(index == array.length) {
      result.add(new String(array));
      return;
    }
    Set<Character> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (set.add(array[i])) {
        swap(array, i, index);
        helper(array, index + 1, result);
        swap(array, i, index);
      }
    }
  }
  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
