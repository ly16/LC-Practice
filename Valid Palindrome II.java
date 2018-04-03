/*
Given a non-empty string s, you may delete at most one character. 
Judge whether you can make it a palindrome.

Example
Given s = "aba" return true
Given s = "abca" return true // delete c

time = O(n)
space = O(1)
*/

public class Solution {
    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                left++;
                right--;
            }
        }
        if (left >= right) {
            return true;
        }
        return afterDelete(s, left + 1, right) || afterDelete(s, left, right - 1);
    }
    
    private boolean afterDelete(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
