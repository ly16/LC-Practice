/*
Remove adjacent, repeated characters in a given string, 
leaving only one character for each group of such characters.
time = O(n), 
space = O(n)      to char array

*/

public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    // input is not empty
    if (input == null || input.length() <= 1) {
      return input;
    }
    int slow = 0;
    char[] array = input.toCharArray();
    for (int fast = 1; fast < array.length; fast++) {
      if (array[fast] == array[slow]) {
        continue;
      }
      array[++slow] = array[fast];
    }
    return new String(array, 0, slow + 1);
  } 
}
