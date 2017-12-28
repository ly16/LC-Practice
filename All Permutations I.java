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
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    char[] setArray = set.toCharArray();
    helper(result, setArray, 0);
    return result;
  }
  public void helper(List<String> result, char[] setArray, int index) {
    if (index == setArray.length) {
      result.add(new String(setArray));
      return;
    }
    for (int i = index; i < setArray.length; i++) {
      swap(setArray, index, i);
      helper(result, setArray, index + 1);
      swap(setArray, index, i);
    }
  }
  public void swap(char[] setArray, int left, int right) {
    char temp = setArray[left];
    setArray[left] = setArray[right];
    setArray[right] = temp;
  }
}

 
