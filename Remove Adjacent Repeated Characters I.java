/*
Remove adjacent, repeated characters in a given string, 
leaving only one character for each group of such characters.
time = O(n), space = O(1)

*/

public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null) {
      return null;
    }
    char[] array = input.toCharArray();
    int s = 0;
    for (int f = 0; f < array.length; f++) {
      if (f == 0 || array[f] != array[s - 1]) { // not including slow is the answer
        array[s++] = array[f];  // array[slow] = array[fast],slow++
      }
    }
    return new String(array, 0, s);  //(array, start, the length)
  } 
}
