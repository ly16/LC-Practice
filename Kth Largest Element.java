/*
Find K-th largest element in an array.

Example
In array [9,3,2,4,8], the 3rd largest element is 4.
In array [1,2,3,4,5], the 1st largest element is 5, 
2nd largest element is 4, 3rd largest element is 3 and etc.

time = O(n) since O(n + n/2 + n/4 + ...) = O(n), which is different from the quicksort
space = O(logn)
*/

class Solution {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int start, int end) {
        int left = start;
        int right = end;
        int pivotIndex = pivotGen(start, end, nums);
        int pivot = nums[pivotIndex];
        
        while(left <= right) {
            // sort from large to small, so the left part is larger
            // similar as find the kth smallest one
            while (left <= right && nums[left] > pivot) {
                left++;
            } 
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(left++, right--, nums);
            }
        }
        if (start + k - 1 <= right) {
            return quickSelect(nums, k, start, right);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start), left, end);
        }
        return nums[right + 1];
    }
    
    private int pivotGen(int start, int end, int[] nums) {
        return start + (int) (Math.random() * (end - start + 1));
    }
    
    private void swap(int left, int right, int[] nums) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}


