/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

time = O(n* n^2)
space = O(n)
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        dfs(s, result, 0, new ArrayList<>());
        return result;
    }
    
    private void dfs(String s, List<List<String>> result, int start, List<String> list) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (isValid(subString)) {
                list.add(subString);
                dfs(s, result, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String subString) {
        int left = 0;
        int right = subString.length() - 1;
        while (left < right) {
            if (subString.charAt(left++) != subString.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
