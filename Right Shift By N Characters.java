/*
Right shift a given string by n characters.

e.g.
shift 3 chars "ab cde" -> "cde ab"
baedc
caedb
cdeab

return "cdeab"

assumption:
The given string is not null.
n >= 0.

time = O(n)
space = O(1)
*/


public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here.
    if (input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    n = n % array.length;
    reverse(array, 0, array.length - n - 1);
    reverse(array, array.length - n, array.length - 1);
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int left, int right) {
    while(left < right) {
      char temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}




