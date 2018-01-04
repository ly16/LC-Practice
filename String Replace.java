/*
time = O(n)
space = O(1) in place

Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
Assump:
input, S and T are not null, S is not empty string

e.g.
input = "appledogapple", S = "apple", T = "cat" -> "catdogcat"
input = "appledogapplem", S = "apple", T = "banana" -> "bananadogbananam"

steps:

if s.length() >= t.length()
appledogapple
s
f(true)

catledogapple
   s
     f(false)
     
catdedogapple
    s
      f(false)
      
catdodogapple
     s
       f (false)

catdogogapple
      s
        f(true)
        
        
catdogcatpple
         s
             f(false)
        
return "catdogcat"



if s.length() < t.length()
appledogapplem__
             s(false)
               f
               
appledogapplem_m
            s(true)
              f
          
          
appledogapplem_m
            s(true)
              f
              
appledogabananam
       s(false) 
        f
        

appledoggbananam
      s (false)
       f
       
appledoogbananam
     s (false)
      f
      
appleddogbananam
    s (true)
     f
     
 bananadogbananam
s 
f

return "bananadogbananam"
*/



public class Solution {
  public String replace(String input, String s, String t) {
    // Write your solution here.
    char[] array = input.toCharArray();
    if (s.length() >= t.length()) {
      return replaceShort(array, s, t);
    }
    return replaceLong(array, s, t);
  }
  
  public String replaceShort(char[] array, String s, String t) {
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      if (fast <= array.length- s.length() && equalString(array, fast, s)) {
        copyString(array, slow, t);
        slow += t.length();
        fast += s.length();
      } else {
        array[slow++] = array[fast++];
      }
    }
    return new String(array, 0, slow);
  }
  
  public String replaceLong(char[] array, String s, String t) {
    List<Integer> match = getMatch(array, s);
    char[] result = new char[array.length + match.size() * (t.length() - s.length())];
    int lastmatch = match.size() - 1;
    int slow = array.length - 1;
    int fast = result.length - 1;
    while (slow >= 0) {
      if (lastmatch >= 0 && slow == match.get(lastmatch)) {
        copyString(result, fast - t.length() + 1, t);
        lastmatch--;
        slow -= s.length();
        fast -= t.length();
      } else {
        result[fast--] = array[slow--];
      }
    }
    return new String(result);
  }
  
  private boolean equalString(char[] array, int start, String s) {
    for (int i = 0; i < s.length(); i++) {
      if (array[start + i] != s.charAt(i)) {
        return false;
      }
    }
    return true;
  }
  
  private void copyString(char[] array, int start, String t) {
    for (int i = 0; i < t.length(); i++) {
      array[start + i] = t.charAt(i);
    }
  }
  
  private List<Integer> getMatch(char[] array, String s) {
    List<Integer> match = new ArrayList<Integer>();
    int i = 0;
    while (i <= array.length - s.length()) {
      if (equalString(array, i, s)) {
        match.add(i + s.length() - 1);
        i += s.length();
      } else {
        i++;
      }
    }
    return match;
  }
}
