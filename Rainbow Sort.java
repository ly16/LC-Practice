/*
Examples:
{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}

-1 -1 -1 0 0 0 x x x x x x x 1 1 1
         l     i           r
*/


public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here.
    // -1 -1 -1 0 0 0 x x x 1 1 1
    if(array == null || array.length <= 1){
      return array;
    }
    int left = 0;
    int right = array.length - 1;
    int i = 0;
    while(i <= right){
      if (array[i] == -1){
        swap(array, left++, i++);
      } else if (array[i] == 0){
        i++;
      } else if (array[i] == 1){
        swap(array, i, right--);
      }
    }
    return array;
  }
  
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}

