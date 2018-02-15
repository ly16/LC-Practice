/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions
There could be duplicate characters in the original set.

Examples
Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []


time = O(n!)
space = O(n)
*/


public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (set == null) {
    	return result;
    }
    StringBuilder sb = new StringBuilder();
    char[] charArray = set.toCharArray();
    Arrays.sort(charArray);
    helper(result, sb, charArray, 0);
    return result;
  } 
  private void helper(List<String> result, StringBuilder sb, char[] charArray, int index) {
  	result.add(sb.toString());
    for (int i = index; i < charArray.length; i++) {
    	if (i == index || charArray[i] != charArray[i - 1]) {
      	sb.append(charArray[i]);
        helper(result, sb, charArray, i + 1);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
