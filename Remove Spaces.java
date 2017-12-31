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
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
        continue;
      }
      array[slow++] = array[fast];
    }
    // space at the end
    if (slow > 0 && array[slow - 1] == ' ') {
      return new String(array, 0, slow - 1);
    }
    return new String(array, 0, slow);
  }
}

