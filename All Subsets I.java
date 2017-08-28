/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.
Assump:
There are no duplicate characters in the original set.


Examples
Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []


time = O(2^n), n is the number of element
space = O(height) = O(n)
*/


public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if (set == null){
      return result;
    }
    
    // transfer set to char array, including index
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(arraySet, sb, 0, result);
    return result;
  }
  
  private void helper(char[] set, StringBuilder sb, int index, List<String> result){
    if (index == set.length) {
      result.add(sb.toString());
      return;
    }
    
    // Not pick the char at index
    helper(set, sb, index + 1, result); // breaking point
    // pick the char at index
    helper(set, sb.append(set[index]), index + 1, result);
    // remove the char at previous level
    sb.deleteCharAt(sb.length() - 1);
  }
}
