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
     f
     
catdedogapple
    s
      f
      
catdodogapple
     s
       f 

catdogogapple
      s
        f(true)
  

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
    public static String replace(String input, String s, String t) {
        // Write your solution here.
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        } else {
            return replaceLonger(array, s, t);
        }
    }

    public static String replaceShorter(char[] input, String s, String t) {
        // fast and slow start from left to right
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            // find the starting point, copy t at slow pointer
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++]; // input[slow] = input[fast]; slow++; fast++;
            }
        }
        return new String(input, 0, slow); // array, offset, length
    }

    public static String replaceLonger(char[] input, String s, String t) {
        ArrayList<Integer> matches = getAllMatches(input, s);
        // add new length needed
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        // fast and slow both from right to the left
        int lastIndex = matches.size() - 1;
        int slow = input.length - 1;
        int fast = result.length - 1;
        while (slow >= 0) {
            if (lastIndex >= 0 && slow == matches.get(lastIndex)) {
                copySubstring(result, fast - t.length() + 1 , t);
                    fast -= t.length();
                    slow -= s.length();
                    lastIndex--;
            } else {
                    result[fast--] = input[slow--];
                   }
            }
            return new String(result);
        }


    //check substring from fromIndex is same as s
    private static boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //copy the string t to result at fromIndex
    private static void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }

    //get all the matches of s end positions
    private static ArrayList<Integer> getAllMatches(char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= input.length - s.length()) { //<=, we want the last one
            if (equalSubstring(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }

}


