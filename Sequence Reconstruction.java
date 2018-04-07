/*
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. 
The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. 
Reconstruction means building a shortest common supersequence of the sequences 
in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). 

Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example
Given org = [1,2,3], seqs = [[1,2],[1,3]]
Return false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

Given org = [1,2,3], seqs = [[1,2]]
Return false
Explanation:
The reconstructed sequence can only be [1,2].

Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Return true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Return true


time = O(V+E)
space = O(V)
*/

public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        // build the map
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                graph.putIfAbsent(seq[i], new ArrayList<Integer>());
                indegree.putIfAbsent(seq[i], 0);
                if (i > 0) {
                    graph.get(seq[i - 1]).add(seq[i]);
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }
        
        // classical BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }
    
        int index = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            if (org[index++] != cur) {
                return false;
            }
            for (int neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return index == org.length;
    }
}

