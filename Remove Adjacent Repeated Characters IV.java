/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.
No adjacent characters should be identified in the final string.

eg.
"abbbccd" -> "ad"
Steps:
-1 0 1 2 3 4 5 6
   a b b b c c d
   e
     i
array[0] = array[0]
-1 0 1 2 3 4 5 6
   a b b b c c d
     e
     i
array[1] = array[1]
     
     
i++
-1 0 1 2 3 4 5 6
   a b b b c c d
   e
         i
array[0] = array[0]


i++
-1 0 1 2 3 4 5 6
   a b b b c c d
   e
             i
array[1] = array[4]
array[0] = array[0]


i++
-1 0 1 2 3 4 5 6
   a b b b c c d
   e
               i
array[1] = array[6]

result:
array[0] = array[0], array[1] = array[6], return "ad"

time = O(n)
space = O(1), no extra stack
*/

public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null || input.length() <= 1) {
      return input;
    }
    
    // convert to charArray
    char[] array = input.toCharArray();
    
    int end = 0;
    for (int i = 1; i < array.length; i++)  {
       if (end == -1 || array[i] != array[end]) {
         // ++end/ end++ are different here
         // end++: array[0] = array[i]
         // ++end: array[1] = array[i], array[0] still there
         array[++end] = array[i];
       } else {
         end--;
         while (i + 1 < array.length && array[i] == array[i + 1]) {
           i++;
         }
       }
    }
    return new String(array, 0 ,end + 1);
  }
}






