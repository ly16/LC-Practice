/*
Find K-th largest element in an array.

Example
In array [9,3,2,4,8], the 3rd largest element is 4.
In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
*/
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums==null || nums.length==0){
            return 0;
        }
        if(k<=0){
            return 0;
        }
        //the largest on the most right, num.length-k+1 is the (index+1)
        return helper(nums, 0, nums.length - 1, nums.length-k+1);
    }
    
    public int helper(int[]nums, int left, int right, int n){
        if(left==right){
            return nums[left];
        }
        int position= partition(nums, left, right);
        if(position+1 ==n){
            return nums[position];
        }else if(position+1 <n){
            return helper(nums, position+1, right,n);
        }else{
            return  helper(nums, left, position-1,n);
        }
    }
    
    public int partition(int[] nums, int left, int right){
        int pivot=nums[left];
        //the first num from the left is the lth largest num
        while(left< right){
            while(left< right && nums[right]>=pivot){
                right--;
            }
            nums[left]= nums[right];
            
            while(left< right && nums[left]<=pivot){
                left++;
            }
            nums[right]= nums[left];
        }
        //insert the pivot to the lth position
        nums[left]=pivot;
        return left;
    }
    
}


