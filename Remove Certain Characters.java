/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
eg:
input = "asjhdjiudh" target = "jiu"
output = "asjhddh"

time = O(n + m), 
space = O(n + m)    addtional set and to char array
*/

public class Solution {
  public String remove(String input, String t) {
    // Write your solution here.
    // input and t are not null
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (!set.contains(array[fast])) {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }
  
  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}


