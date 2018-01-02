/*
Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.

Examples

“ I  love  Google  ” → “Google love I”

Corner Cases

If the given string is null, we do not need to do anything.

time = O(n)
space = O(n)  // string builder
*/

public class Solution {
  public String reverseWords(String input) {
    // Write your solution here.
            if (input == null || input.length() <= 1) {
            return input;
        }

        String[] array = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }

        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
  }
}
