/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0,1] is the same as [1,0] and thus will not appear together in edges.

time = O(V+E)
space = O(V)
*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        // e = v - 1
        if (edges.length != n - 1) {
            return false;
        }
        
        // initialization the graph
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graphMap.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int cur = edges[i][0];
            int nei = edges[i][1];
            graphMap.get(cur).add(nei);
            graphMap.get(nei).add(cur);
        }
        
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> result = new HashSet<>();
        queue.add(0);
        result.add(0);
        
        while (!queue.isEmpty()) {
            int head = queue.poll();
            for (Integer neighbor : graphMap.get(head)) {
                if (!result.contains(neighbor)) {
                    result.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result.size() == n;
    }
}
