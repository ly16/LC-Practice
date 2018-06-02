/*
Description
Give a string, you can choose to split the string after one character or two adjacent characters, 
and make the string to be composed of only one character or two characters. Output all possible results.

Example
Given the string "123"
return [["1","2","3"],["12","3"],["1","23"]]

time = O(n^2)
space = O(n)
*/

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        dfs(s, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(String s, List<List<String>> result, List<String> list, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<> (list));
            return;
        }
        
        for (int i = start; i < start + 2 && i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            list.add(subString);
            dfs(s, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
