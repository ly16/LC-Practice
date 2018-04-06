/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, 
for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example
Given n = 2, prerequisites = [[1,0]]
Return [0,1]
Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]

time = O(V+E)
space = O(V)
*/

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = i;
            }
            return ans;
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
        
        // convert ArrayList to int[] 
        if (result.size() == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < result.size(); i++) {
                ans[i] = result.get(result.size() - 1 - i);
            }
            return ans;
        }
        return new int[0];
    }
}
