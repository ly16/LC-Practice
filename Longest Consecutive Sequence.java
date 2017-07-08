/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Clarification
Your algorithm should run in O(n) complexity.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
*/


public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i< num.length;i++){
            set.add(num[i]);
        }
        
        int longest=0;
        for(int i=0; i<num.length; i++){
            int down= num[i]-1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            
            int up= num[i]+ 1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            //up and down only in the for loop
            //up is already added 1
            longest= Math.max(longest, up-down-1);
        }
        return longest;
    }
}
