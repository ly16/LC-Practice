/*
Given an array of integers, find a contiguous subarray which has the largest sum.
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            max= Math.max(max, sum);
            sum= Math.max(sum, 0);
        }
        return max;
    }
}
