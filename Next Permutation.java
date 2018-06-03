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

如果上来想不出方法，可以试着找找规律，我们关注的重点应是原数组末尾。

从末尾往左走，如果一直递增，例如...9,7,5，那么下一个排列一定会牵扯到左边更多的数，直到一个非递增数为止，
例如...6,9,7,5。对于原数组的变化就只到6这里，和左侧其他数再无关系。6这个位置会变成6右侧所有数中比6大的最小的数，
而6会进入最后3个数中，且后3个数必是升序数组。

所以算法步骤如下：
从右往左遍历数组nums，直到找到一个位置i，满足nums[i] > nums[i - 1]或者i为0。
i不为0时，用j再次从右到左遍历nums，寻找第一个nums[j] > nums[i - 1]。而后交换nums[j]和nums[i - 1]。
注意，满足要求的j一定存在！且交换后nums[i]及右侧数组仍为降序数组。
将nums[i]及右侧的数组翻转，使其升序。

Q：i为0怎么办？
A：i为0说明整个数组是降序的，直接翻转整个数组即可。

Q：有重复元素怎么办？
A：在遍历时只要严格满足nums[i] > nums[i - 1]和nums[j] > nums[i - 1]就不会有问题。

Q：元素过少是否要单独考虑？
A：当元素个数小于等于1个时，可以直接返回。

time = O(n)
space = O(1)
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        // write your code here
        // 1,2,3,5,7
        // 1,3,7,5,2 -> 1,5,7,3,2 -> 1,5,2,3,7
        if (nums == null || nums.length <= 1) {
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
