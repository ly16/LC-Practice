/*
Move 0s to the end, while the order of other elements does not matter.

Eg.
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
1 0 3 0 1
i       r
1 0 3 0 1
  i     r
swap
1 1 3 0 0
    r i
end
*/


public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return array;
    }
    moveZero(array, 0, array.length - 1);
    return array;
  }
  
  private void moveZero(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int leftIndex = left;
    int rightIndex = right;
    while (leftIndex <= rightIndex) {
      if (array[leftIndex] != 0) {
        leftIndex++;
      } else if (array[rightIndex] == 0) {
        rightIndex--;
      } else {
        swap(array, leftIndex++, rightIndex--);
      }
    }
  }
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
