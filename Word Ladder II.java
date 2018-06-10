/*
Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

time = O(n! + 26^l)
space = O(n^2)
*/


public class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        Set<String> set = new HashSet<String>(wordList);
        Map<String, Integer> distance = new HashMap<String, Integer>();
        Map<String, Set<String>> neighbors = new HashMap<String, Set<String>>();
        
        distance.put(beginWord, 0);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        
            // bfs
        while (!queue.isEmpty()) { 
            String word = queue.poll();
            if (word.equals(endWord)) {
                break;
            }
            
            int step = distance.get(word) + 1;
            // change letters in the word
            for(int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(i)) {
                        continue;
                    }
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (!set.contains(newWord)) {
                        continue;
                    }
                    // if newWord already existed, choose the smaller step
                    if (step <= distance.getOrDefault(newWord, Integer.MAX_VALUE)) {
                        queue.add(newWord);
                        distance.put(newWord, step);
                        if (!neighbors.containsKey(word)) {
                            neighbors.put(word, new HashSet<String>());
                        }
                        neighbors.get(word).add(newWord);
                    }
                }
            }
        }
        // current String list
        List<String> list = new ArrayList<String>();
        dfs(result, list, neighbors, beginWord, endWord);
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, Map<String, Set<String>> neighbors, String word, String endWord) {
        if (word.equals(endWord)) {
            list.add(word);
            result.add(new ArrayList<String>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(word);
        if (neighbors.containsKey(word)) {
            for (String s : neighbors.get(word)) {
                dfs(result, list, neighbors, s, endWord);
            }
        }
        list.remove(list.size() - 1);
    }
}
