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
    if (array == null || array.length <= 1){
      return array;
    }
    int right = array.length - 1;
    int i = 0;
    // swap when array[i] == 0, but array[right] != 0
    while (i <= right){
      if (array[i] != 0){
        i++;
      } else if (array[right] == 0) {
        right--;
      } else {
        swap(array, i++, right--);
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
