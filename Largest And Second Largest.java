/*
Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. 
Return the largest number and 2nd largest number.

Assumptions
The given array is not null and has length of at least 2

Examples
{2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.

time = O(n + logn) = O(n)
space = O(n*log(n))
*/

public class Solution {
  static class Element {
    int value;
    List<Integer> comparedValues;
    Element(int value) {
      this.value = value;
      this.comparedValues = new ArrayList<>();
    }
  }
  public int[] largestAndSecond(int[] array) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the second largest number.
    // the given array is not null and has length of at least 2
    Element[] helper = convert(array);    
    int n = array.length;
    while (n >= 2) {
      compSwap(helper, n);              
      // in case of the odd length
      n = (n + 1) / 2;
    }
    return new int[] {helper[0].value, largest(helper[0].comparedValues)}; 
  }
  
  private Element[] convert(int[] array) {
    Element[] helper = new Element[array.length];
    for (int i = 0; i < array.length; i++) {
      helper[i] = new Element(array[i]);
    }
    return helper;
  }
  
  private void compSwap(Element[] helper, int n) {
    for (int i = 0; i < n / 2; i++) {
      if (helper[i].value < helper[n - i - 1].value) {
        swap(helper, i, n - i - 1);         
      }
      helper[i].comparedValues.add(helper[n - i - 1].value);
    }
  }
  
  private int largest(List<Integer> list) {
    int largest = list.get(0);
    for (int num : list) {
      largest = Math.max(largest, num);
    }
    return largest;
  }
  
  private void swap(Element[] helper, int left, int right) {
    Element temp = helper[left];
    helper[left] = helper[right];
    helper[right] = temp;
  }
}
