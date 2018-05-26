/*
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary

Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

time = O(n*26^l) for all of the possible combinations, l is word length, n is the dict size
space = O(n) for all kinds of list, queue, set
*/

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || start == null || end == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        set.add(start);
        queue.offer(start);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String next : getNext(word, dict)) {
                    if (set.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return length;
                    }
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNext(String word, Set<String> dict) {
        List<String> nextList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) { // O(l)
            for (char c = 'a'; c <= 'z'; c++) { // O(26)
                if (c == word.charAt(i)) {
                    continue;
                }
                String newNext = replaceChar(c, i, word);//O(l)
                if (dict.contains(newNext)) {// O(l) not O(1)
                   nextList.add(newNext); 
                }
            }
        }
        return nextList;
    }
    
    private String replaceChar(char c, int i, String word) {
        char[] array = word.toCharArray();
        array[i] = c;
        return new String(array);
    }
}


// leetcode version:
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> wordDict = new HashSet<>();
        for (String s : wordList) {
            wordDict.add(s);
        }
        
        wordDict.add(beginWord);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        
        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : findNext(cur, wordDict)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(endWord)) {
                        return count;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return 0;
    }
    
    private List<String> findNext(String cur, Set<String> wordDict) {
        List<String> nextList = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String tmp = replaceChar(cur, i, c);
                if (wordDict.contains(tmp)) {
                    nextList.add(tmp);
                }
            }
        }
        return nextList;
    }
    
    private String replaceChar(String cur, int i, char c) {
        char[] array = cur.toCharArray();
        array[i] = c;
        return new String(array);
    }
}
