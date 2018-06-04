/*
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Example 3:
Input: "carerac"
Output: true

time = O(n) n is the length of the string
space = O(n) for the set
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<Character> count = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!count.contains(c)) {
                count.add(c);
            } else {
                count.remove(c);
            }
        }
        return count.size() < 2;
    }
}
