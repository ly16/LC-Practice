/*
Reverse the words in a sentence.

Assump:
Words are separated by single space
There are no heading or tailing white spaces

time = O(kn)
space = O(1) no recursion
e.g.
"an apple" -> "apple an"
steps:
0 1 2 3 4 5 6 7
a n   a p p l e
s i
reverse every word:
0 1 2 3 4 5 6 7
n a   a p p l e
s i


i++
0 1 2 3 4 5 6 7
n a   a p p l e
s   i


i++
0 1 2 3 4 5 6 7
n a   a p p l e
      i
      s
      
i++
0 1 2 3 4 5 6 7
n a   e p p l a
      s       i
      
      
i++
0 1 2 3 4 5 6 7
n a   e l p p a
        s   i
        
        
reverse the whole array:
0 1 2 3 4 5 6 7
a a   e l p p n
l             r

0 1 2 3 4 5 6 7
a p   e l p a n
  l         r
  
0 1 2 3 4 5 6 7
a p p e l   a n
    l     r
    
0 1 2 3 4 5 6 7
a p p l e   a n
      l r

return "apple an"

time = O(n)
space = O(1)
*/

public class Solution {
  public String reverseWords(String input) {
    // Write your solution here.
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int left = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
        left = i;
      }
      if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
        int right = i;
        reverse(array, left, right);
      }
    }
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int left, int right) {
    while (left < right) {
      char temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}
