/*
Given an array of n objects with k different colors (numbered from 1 to k), 
sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Notice
You are not suppose to use the library's sort function for this problem.
k <= n

Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors==null || colors.length==0){
            return;
        }
        colorSort(colors, 0, colors.length-1, 1, k);
    }
    
    public void colorSort(int[] colors, int start, int end, int from, int to) {
        if(from==to){
            return;
        }
        if(start>=end){
            return;
        }
        int pivot=(from + to)/2;
        int left=start, right=end;
        while(left<=right){
            //color[left]<=privot, "="can be used, which is different from quickSort
            while(left<=right && colors[left]<=pivot){
                left++;
            }
            while(left<=right && colors[right]>pivot){
                right--;
            }
            if(left<=right){
                int t= colors[left];
                colors[left]= colors[right];
                colors[right]= t;
                
                left++;
                right--;
            }
        }
        colorSort(colors, start, right, from, pivot);
        colorSort(colors, left, end, pivot+1, to);
    }
}
