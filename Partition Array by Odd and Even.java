/*
Partition an integers array into odd number first and even number second.

Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]
*/


public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int odd=0, even=nums.length-1;
        while(odd<even){
            while(odd<even && nums[odd]%2==1){
                odd++;
            }
            while(odd<even && nums[even]%2==0){
                even--;
            }
            //swap odd and even numbers
            if(odd<even){
                int temp=nums[odd];
                nums[odd]=nums[even];
                nums[even]=temp;
                odd++;
                even--;
            }
        }
    }
}
