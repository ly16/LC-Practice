/*
Examples:
{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}

-1 -1 -1 0 0 0 x x x x x x x 1 1 1
         i     j           k
time = O(n)
space = O(1)
*/


public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here.
    // -1 -1 -1 00000 xxxx 111111
    //          i     j  k
    if (array == null || array.length <= 1) {
      return array;
    }
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    while(j <= k) {
      if(array[j] == -1) {
        swap(array, i++, j++);
      } else if (array[j] == 0) {
        j++;
      } else {
        swap(array, j, k--);
      }
    }
    
    return array;
  }
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}

