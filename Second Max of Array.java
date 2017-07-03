/*
Find the second max number in a given array.

Example
Given [1, 3, 2, 4], return 3.
Given [1, 2], return 1.
*/
public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        /* your code */
        //put the smaller number in first two numbers to "second"
        int max=Math.max(nums[0],nums[1]);
        int second=Math.min(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]>=max)
            {
                second=max;
                max=nums[i];
            }else if(nums[i]>=second)
            {
                second=nums[i];
            }
        }
        return second;
    }
}
