/*
Given an array of integers, find the subarray with smallest sum.
Return the sum of the subarray.

Example
For [1, -1, -2, 1], return -3.
*/


public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums==null){
            return 0;
        }
        int len=nums.size();
        int[] localmin=new int[len];
        int[] globalmin=new int[len];
        for(int i=0;i<len;i++){
            if(i==0){
                localmin[i]=globalmin[i]=nums.get(i);
            }
            else{
                localmin[i]=Math.min(localmin[i-1]+nums.get(i), nums.get(i));
                globalmin[i]=Math.min(globalmin[i-1], localmin[i]);
            }
        }
        return globalmin[len-1];
    }
}
