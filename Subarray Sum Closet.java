/*
Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

*/
class Pair{
        int sum, index;
        public Pair(int s, int i) {
        sum = s;
        index = i;
        }
}
    
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result= new int[2];
        if(nums==null ||nums.length==0){
            return result;
        }
        int n= nums.length;
        if(n==1){
            result[0]=result[1]=0;
            return result;
        }
        
        //include 0, so n+1
        Pair[] p= new Pair[n+1];
        int prev=0;
        p[0]= new Pair(0,0);
        for (int i = 1; i <= n; i++) {
            p[i] = new Pair(prev + nums[i-1], i);
            prev = p[i].sum;
        }
        Arrays.sort(p, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        
        int answer= Integer.MAX_VALUE;
        for(int i=1; i<= n;i++){
            if(answer> p[i].sum-p[i-1].sum){
                answer= p[i].sum-p[i-1].sum;
                int[] temp = new int[]{p[i].index- 1 , p[i - 1].index - 1};
                Arrays.sort(temp);
                result[0] = temp[0]+1;
                result[1] = temp[1];
            }
        }
         return result;
    }
}


