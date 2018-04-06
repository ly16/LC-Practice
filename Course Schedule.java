/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example
Given n = 2, prerequisites = [[1,0]]
Return true
Given n = 2, prerequisites = [[1,0],[0,1]]
Return false

methods:
1. generate a coursemap from the matrix
2. same as topological sorting
3. compare the length with the numCourses

time = O(n)
space = O(n)
*/


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        // build up a map for prerequisites
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int nei = prerequisites[i][1];
            courseMap.get(cur).add(nei);
        }
        
        // topological sorting
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (Integer neighbor : courseMap.get(i)) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);
                result.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            for (Integer neighbor : courseMap.get(head)) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) - 1);
                } 
                if (map.get(neighbor) == 0) {
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result.size() == numCourses;
    }
}
