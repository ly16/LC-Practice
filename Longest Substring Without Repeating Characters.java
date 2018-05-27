/*
Given a string, find the longest substring without any repeating characters and return the length of it. 
The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.

time = O(2n) = O(n)
space = O(n)
*/

public class Solution {
  public int longest(String input) {
    // Write your solution here.
    char[] array = input.toCharArray();
    Set<Character> set = new HashSet<>();
    int slow = 0;
    int fast = 0;
    int longest = 0;
    while (fast < array.length) {
      if (!set.contains(array[fast])) {
        set.add(array[fast++]);
        longest = Math.max(longest, fast - slow);
      } else {
        set.remove(array[slow++]);
      }
    }
    return longest;
  }
}


// leetcode version (optional)
// time = O(n), space = O(m) for the constant int[]

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // int[256] for Extended ASCII
        int[] record = new int[256];
        int result = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            // appear before
            i = Math.max(i, record[s.charAt(j)]);
            result = Math.max(result, j - i + 1);
            // record j 
            record[s.charAt(j)] = j + 1;
        }
        return result;
    }
}
