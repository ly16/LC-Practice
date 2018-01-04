/*
Given an array of elements
{N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 
The given array is not null
e.g.
{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
steps:
0 1 2 3 4 5
1 2 3 4 5 6
 lm   m rm
 

0 1   2 3 4 5
1 4   3 2 5 6
       lm m rm


0 1   2 3 4 5
1 4   3 5 2 6
       lm m rm 
       
return 1 4 3 5 2 6

time = O(nlogn)
space = O(n) = O(2^logn)= 1+2+4+..+n 
*/

public class Solution {
  public int[] reorder(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return array;
    }
    if (array.length % 2 == 0) {
      reorder(array, 0, array.length - 1);
    } else {
      reorder(array, 0, array.length - 2);
    }
    return array;
  }
  
  private void reorder(int[] array, int left, int right) {
    int length = right - left + 1;
    if (length <= 2) {
      return;
    }
    int mid = left + length / 2;
    int lm = left + length / 4;
    int rm = left + 3 * length / 4;
    reverse(array, lm, mid - 1);
    reverse(array, mid, rm - 1);
    reverse(array, lm, rm - 1);
    reorder(array, left, 2 * (lm - left) + left - 1);
    reorder(array, 2 * (lm - left) + left, right);
  }
  
  private void reverse (int[] array, int left, int right) {
    while (left < right) {
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}

