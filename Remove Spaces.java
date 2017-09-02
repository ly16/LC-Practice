/*
Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:
The given string is not null.

Examples:
"abc    d    w" -> "abc d w"

time = O(n), space = O(1)
*/

public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here.
    if (input.isEmpty()) {  //.isEmpty()
      return input;
    }
    char[] array = input.toCharArray();
    int end = 0;  // not include end as answer
    for (int i = 0; i< array.length; i++) {
      if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
        continue;
      }
      array[end++] = array[i];
    }
    
    // space at the end
    if (end > 0 && array[end - 1] == ' ') {
      return new String(array, 0, end - 1); // char array
    }
    return new String(array, 0, end);
  }
}


