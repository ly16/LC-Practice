/*

Given a dictionary containing many words, find the largest product of two words’ lengths, 
such that the two words do not share any common characters.

Assumptions
The words only contains characters of 'a' to 'z'
The dictionary is not null and does not contains null string, and has at least two strings
If there is no such pair of words, just return 0

Examples
dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)



time = O(mn + n^2 + n)
space = O(n)  for the hashmap
*/

public class Solution {
  public int largestProduct(String[] dict) {
    // Write your solution here
    HashMap<String, Integer> mask = getMask(dict);
    Arrays.sort(dict, new Comparator<String>(){
    	@Override
      public int compare(String s1, String s2) {
      	if (s1.length() == s2.length()) {
        	return 0;
        }
        return s1.length() > s2.length() ? -1 : 1;
      }
    });
    int max = 0;
    for (int i = 1; i < dict.length; i++) {
    	for (int j = 0; j < i; j++) {
      	int product = dict[i].length() * dict[j].length();
        if (product <= max) {
        	break;
        }
        int iMask = mask.get(dict[i]);
        int jMask = mask.get(dict[j]);
        if ((iMask & jMask) == 0) {
        	max = product;
        }
      }
    }
    return max;
  }
  private HashMap<String, Integer> getMask(String[] dict) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String str : dict) {
    	int mask = 0;
      for (int i = 0;  i < str.length(); i++) {
      	mask |= 1 << (str.charAt(i) - 'a');
      }
      map.put(str, mask);
    }
    return map;
  }
}
