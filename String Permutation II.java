/*
Description
Given a string, find all permutations of it without duplicates.

Example
Given "abb", return ["abb", "bab", "bba"].
Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].

time = O(n!)
space = O(n)
*/

public class Solution {
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        int len = str.length();
        boolean[] visited = new boolean[len];
        String cur = "";
        char[] array = str.toCharArray();
        Arrays.sort(array);
        dfs(cur, array, visited, result);
        return result;
    }
    
    private void dfs(String cur, char[] array, boolean[] visited, List<String> result) {
        if (cur.length() == array.length) {
            result.add(new String(cur));
            return;
        }
        
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && array[i] == array[i - 1] && !visited[i - 1]) {
                continue;
                
            }
            cur += array[i];
            visited[i] = true;
            dfs(cur, array, visited, result);
            cur = cur.substring(0, cur.length() - 1);
            visited[i] = false;
        }
    }
}
