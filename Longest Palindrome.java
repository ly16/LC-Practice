/*
Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Example
Given s = "abccccdd" return 7
One longest palindrome that can be built is "dccaccd", whose length is 7.

time = O(n)
space = O(n)
*/

public class Solution {
    public int longestPalindrome(String s) {
        // The longest size should be odd number
        // so we should remove all the odd elements + 1
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> visited = new HashSet<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (visited.contains(c)) {
                visited.remove(c);
            } else {
                visited.add(c);
            }
        }

        if (visited.size() > 0) {
            return s.length() - visited.size() + 1;
        }
        return s.length();
    }
}
