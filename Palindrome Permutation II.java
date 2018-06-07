/*
Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

Example 1:
Input: "aabb"
Output: ["abba", "baab"]

Example 2:
Input: "abc"
Output: []

time = O(n!) for the half permutation
space = O(n)
*/

class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        String mid = "";
        int odd = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            // %, not /
            odd = odd + (map.get(c) % 2 == 1 ? 1 : -1);
        }
        if (odd > 1) {
            return result;
        }
        List<Character> permuList = new ArrayList<>();
        // Map.Entry not map.Entry
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value % 2 == 1) {
                mid = mid + key;
            }
            for (int i = 0; i < value / 2; i++) {
                permuList.add(key);
            }
        }
        dfs(result, permuList, new StringBuilder(), new boolean[permuList.size()], mid);
        return result;
    }
    
    // all permutations of the half characters
    private void dfs(List<String> result, List<Character> permuList, StringBuilder sb, boolean[] visited, String mid) {
        if (sb.length() == permuList.size()) {
            result.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for (int i = 0; i < permuList.size(); i++) {
            if (visited[i]) {
                continue;
            }
            // permuList.get(), not visited[i]
            if (i > 0 && permuList.get(i) == permuList.get(i - 1) && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            sb.append(permuList.get(i));
            dfs(result, permuList, sb, visited, mid);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
