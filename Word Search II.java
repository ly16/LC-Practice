/*
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" 
cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:
Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Output: ["eat","oath"]

time = O(N!)  N=mn
space = O(N) for the Trie
*/


class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String end;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = builder(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(result, board, i, j, root);
            }
        }
        return result;
    }
    
    public TrieNode builder(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int pos = c - 'a';
                if (cur.children[pos] == null) {
                    cur.children[pos] = new TrieNode();
                }
                cur = cur.children[pos];
            }
            cur.end = word;
        }
        return root;
    }
    
    public void dfs(List<String> result, char[][] board, int i, int j, TrieNode root) {
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        if (root.end != null) {
            result.add(root.end);
            root.end = null;   //deduplicate
        }
        
        board[i][j] = '#';
        if (i > 0) {
            dfs(result, board, i - 1, j, root);
        }
        if (i < board.length - 1) {
            dfs(result, board, i + 1, j, root);
        }
        if (j > 0) {
            dfs(result, board, i, j - 1, root);
        }
        if (j < board[0].length - 1) {
            dfs(result, board, i, j + 1, root);
        }
        // chose each char only once
        board[i][j] = c;
    }
}
