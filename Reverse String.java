/*
Reverse a given string.

eg.
"fdhjk" -> "kjhdf"
steps:
f d h j k
l       r
k d h j f
l       r


l++, r--
k d h j f
  l   r
k j h d f
  l   r 

l++, r--, l == r
stop, return "kjhdf"

time = O(n)
space = O(1)
*/


public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    if (input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      char temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
    return new String(array);
  }
}
