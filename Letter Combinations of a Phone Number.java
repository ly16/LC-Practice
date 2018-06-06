/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

time = O(k^n) for k position, each position have n possible elements
space = O(n) for the map
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, map, digits);
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, Map<Character, char[]> map, String digits) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            dfs(result, sb, map, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
