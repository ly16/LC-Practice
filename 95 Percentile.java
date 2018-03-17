/*
Given a list of integers representing the lengths of urls, 
find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).

Assumptions
The maximum length of valid url is 4096
The list is not null and is not empty and does not contain null

Examples
[1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.

time = O(n)
space = O(n)  for int[] array
*/

public class Solution {
  public int percentile95(List<Integer> lengths) {
    // Write your solution here.
    int[] array = new int[4097];
    for (int len : lengths) {
    	array[len]++;
    }
    
    int sum = 0;
    int index = 4097;
    while (sum <= 0.05 * lengths.size()) {
    	sum += array[--index];
    }
    return index;
  }
}
