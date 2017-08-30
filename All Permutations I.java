/*
Given a string with no duplicate characters, return a list with all permutations of the characters.
Example:
Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

n is the number of position
time = O(n!)
space = O(n)

Steps:
                        {}    
index = 0       a       b         c
index = 1    b   c    a   c     a   b
index = 2    c   b    c   a     b   a
                

*/


public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
   List<String> result = new ArrayList<>();
   if (set == null){
     return result;
   }
   
   // change set to charArray
   char[] array = set.toCharArray();
   helper(array, 0, result);
   return result;
  }
  
  private void helper(char[] array, int index, List<String> result){
  // stop permulation
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    
    for(int i = index; i < array.length; i++) {
      swap(array, index, i);
      helper(array, index + 1, result);     //check whether terminate
      // swap back from previous level
      swap(array, index, i);
    }
  }
  
  private void swap(char[] array, int left, int right) {
    char temp = array[left];    // type is char
    array[left] = array[right];
    array[right] = temp;
  }
}
