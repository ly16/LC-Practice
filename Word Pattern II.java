/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a 
letter in pattern and a non-empty substring in str.

Example 1:
Input: pattern = "abab", str = "redblueredblue"
Output: true

Example 2:
Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
Output: true

Example 3:
Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false

Notes:
You may assume both pattern and str contains only lowercase letters.

time = O(n!)
space = O(n)
*/


public class Solution {
  public boolean wordPatternMatch(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    return isMatch(str, 0, pattern, 0, map, set);
  }
  
  boolean isMatch(String str, int sIndex, String pat, int pIndex, Map<Character, String> map, Set<String> set) {
    // base case
    if (sIndex == str.length() && pIndex == pat.length()) return true;
    if (sIndex == str.length() || pIndex == pat.length()) return false;
    
    char c = pat.charAt(pIndex);
    if (map.containsKey(c)) {
      String s = map.get(c);
      // then check if we can use it to match str[i...i+s.length()]
      if (!str.startsWith(s, sIndex)) {
        return false;
      }
      return isMatch(str, sIndex + s.length(), pat, pIndex + 1, map, set);
    }
    
    // pattern character does not exist in the map
    for (int i = sIndex; i < str.length(); i++) {
      String p = str.substring(sIndex, i + 1);
      if (set.contains(p)) {
        continue;
      }
      map.put(c, p);
      set.add(p);
      if (isMatch(str, i + 1, pat, pIndex + 1, map, set)) {
        return true;
      }
      map.remove(c);
      set.remove(p);
    }
    return false;
  } 
}
