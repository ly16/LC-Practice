/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, 
return if the string matches the abbreviation.

Assumptions:
The original string only contains alphabetic characters.
Both input and pattern are not null.

Examples:
pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.

time = O(n)   // n is the length of pattern
space = O(1)
*/

public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here.
    int i = 0;
    int p = 0;
    while (i < input.length() && p < pattern.length()) {
      // if element is char
      if (pattern.charAt(p) < '0' || pattern.charAt(p) > '9') {
        if (pattern.charAt(p) != input.charAt(i)) {
          return false;
        }
        i++;
        p++;
      // if element is number
      } else {
        int count = 0;
        while (p < pattern.length() && pattern.charAt(p) >= '0' && pattern.charAt(p) <= '9') {
          count = count * 10 + pattern.charAt(p) - '0';
          p++;
        }
        i += count;
      }
    }
    return i == input.length() && p == pattern.length();
  }
}
