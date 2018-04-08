/*
Implement next permutation, 
which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, 
it must rearrange it as the lowest possible order (ie, sorted in ascending order).

Example
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

time = O(n)
space = O(1)
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        // write your code here
        // 1,2,3,5,7
        // 1,3,7,5,2 -> 1,5,7,3,2 -> 1,5,2,3,7
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i != 0) {
            // find the smallest larger on the right hand side
            int j = nums.length - 1;
            while (nums[i - 1] >= nums[j]) {
                j--;
            }
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
