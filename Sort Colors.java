/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Notice
You are not suppose to use the library's sort function for this problem. 
You should do it in-place (sort numbers in the original array).

Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length<=1){
            return;
        }
        
        int left=0;
        int right=nums.length-1;
        int i=0;
        while(i<=right){
            if(nums[i]==0){
                swap(nums, left, i);
                left++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums, right, i);
                right--;
                //i does not increase here
            }
        }
        
    }
    private void swap(int[] nums, int a, int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
}
