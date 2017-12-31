/*
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assump:
Both large and small are not null
If small is empty string, return 0

"abbaabbab","bbab" return i = 5
time = O(n * m), n = large.length(), m = small.length()
space = O(1)
*/

public class Solution {
  public int strstr(String large, String small) {
    // write your solution here
    if (small.isEmpty()) {
      return 0;
    }
    if (large.length() < small.length()) {
      return -1;
    }
    for (int i = 0; i <= large.length() - small.length(); i++) {
      int k = i;
      int j = 0;
      for (j = 0; j < small.length(); j++) {
        if (large.charAt(k) != small.charAt(j)) {
          break;
        }
        k++;
      }
      if (j == small.length()) {
        return i;
      }
    }
    return -1;
  }
}

