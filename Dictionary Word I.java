/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions
The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

Examples
Dictionary: {“bob”, “cat”, “rob”}
Word: “robob” return false
Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"

time = O(n^3) for the substring API
space = O（n）
*/

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here.
    boolean[] canBreak = new boolean[input.length() + 1];
    Set<String> set = toSet(dict);
    canBreak[0] = true;
    for (int i = 1; i < input.length() + 1; i++) {
      for (int j = 0; j < i; j++) {
        if (canBreak[j] && set.contains(input.substring(j, i))) {
          canBreak[i] = true;
          break;
        }
      }
    }
    return canBreak[input.length()];
  }
  private Set<String> toSet (String[] dict) {
    Set<String> set = new HashSet<String> ();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  }
}
