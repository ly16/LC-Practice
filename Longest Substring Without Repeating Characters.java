/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.

time = O(n)
space = O(1) inplace
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
