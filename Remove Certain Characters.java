/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
eg:
input = "asjhdjiudh" target = "jiu"
output = "asjhddh"

time = O(n), space = O(m), m is the size of target
*/

public class Solution {
  public String remove(String input, String t) {
    // Write your solution here.
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t); //build string to set
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (!set.contains(array[fast])) {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }
  
  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < t.length(); i++) {    // string.length()
      set.add(t.charAt(i));
    }
    return set;
  }
}


