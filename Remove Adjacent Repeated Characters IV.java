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
space = O(1), no extra stack, inplace
*/

public class Solution {
  public String deDup(String input) {
    // Write your solution here.
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 1; fast < array.length; fast++) {
      if (slow == -1 || array[fast] != array[slow]) {
        array[++slow] = array[fast];
      } else {
        slow--;
        while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
          fast++;
        }
      }
    }
    return new String(array, 0, slow + 1);
  }
}






