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
    if (large.length() < small.length()) {
      return -1;
    }
    if (small.length() == 0) {
      return 0;
    }
    
   for (int i = 0; i <= large.length() - small.length(); i++) { //"=" we should ensure we can iterate the whole small length
     if (equals(large, i, small)) {
       return i;
     }
   }
      return -1;
  }
  
  public boolean equals(String large, int start, String small) {
    for (int i = 0; i < small.length(); i++) {
      if (large.charAt(i + start) != small.charAt(i)) {
        return false;
      }
    }
    return true;
  }
  
}
