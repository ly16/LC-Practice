/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions
s is not null or empty.
l is not null.

Examples
l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").

time = O(m + n)
space = O(m)  for hashmap
*/

public class Solution {
  public List<Integer> allAnagrams(String s, String l) {
    // Write your solution here.
    // abcbac    ab
    // s
    //   f
    List<Integer> result = new ArrayList<>();
    if (l.length() == 0) {
      return result;
    }
    if (l.length() < s.length()) {
      return result;
    }
    Map<Character, Integer> map = getMap(s);
    int match = 0;
    for (int i = 0; i < l.length(); i++) {
      char right = l.charAt(i);
      Integer freq = map.get(right);
      if (freq != null) {
        map.put(right, freq - 1);
        if (freq == 1) {
          match++;
        }
      }
      
      if (i >= s.length()) {
        char left = l.charAt(i - s.length());
        freq = map.get(left);
        if (freq != null) {
          map.put(left, freq + 1);
          if (freq == 0) {
            match--;
          }
        }
      }
      
      if (match == map.size()) {
        result.add(i - s.length() + 1);
      }
    }
    return result;
  }
  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Integer freq = map.get(s.charAt(i));
      if (freq != null) {
        map.put(s.charAt(i), freq + 1);
      } else {
        map.put(s.charAt(i), 1);
      }
    }
    return map;
  }
}
