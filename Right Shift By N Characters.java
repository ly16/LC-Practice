/*
Right shift a given string by n characters.

e.g.
shift 3 chars "ab cde" -> "cde ab"
baedc
caedb
cdeab

return "cdeab"

time = O(n)
space = O(1)
*/

public class Solution {
  public String rightShift(String input, int n) {
       // Write your solution here.
      if (input == null || input.length() <= 1) {
          return input;
      }
      char[] array = input.toCharArray();
      n %= array.length;  //n = n % array.length, 3 % 5 = 23 % 5
      // right part
      reverse(array, array.length - n, array.length - 1);
      // left part
      reverse(array, 0, array.length - n - 1);
      // whole 
      reverse(array, 0 ,array.length - 1);
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



