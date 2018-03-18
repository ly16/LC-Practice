/*

Given a string, determine if it is a palindrome, 
considering only alphanumeric characters('0'-'9','a'-'z','A'-'Z') and ignoring cases.

For example,
"an apple, :) elp pana#" is a palindrome.
"dia monds dn dia" is not a palindrome.

time = O(n) for the linear scan
space = O(1)
*/

public class Solution {
  public boolean valid(String input) {
    // time = O(n), space = O(1)
    if (input == null || input.length() == 0) {
    	return true;
    }
    
    int left = 0;
    int right = input.length() - 1;
    while (left < right) {
      // remove the non-letter/digit chars
    	while (left < input.length() && !isValid(input.charAt(left))) {
      	left++;
      }
      // case of "*&%*.../"
      if (left == input.length()) {
      	return true;
      }
      // remove the non-letter/digit chars
      while (right >= 0 && !isValid(input.charAt(right))) {
      	right--;
      }
      
      if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
      	break;
      } else {
      	left++;
        right--;
      }
    }
    return left >= right;
  }
  
  private boolean isValid(char c) {
  	return Character.isLetter(c) || Character.isDigit(c);
  }
}
