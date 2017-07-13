/*
Implement an algorithm to determine if a string has all unique characters.

Example
Given "abc", return true.
Given "aab", return false.
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        //boolean[] charSet = new boolean[Character.MAX_VALUE + 1];
        boolean[] char_set= new boolean[256];
        for(int i=0; i<str.length(); i++){
            int val=str.charAt(i);
            //the char is already existed
            if(char_set[val]){
                return false;
            }
            //if char is not existed, and keep it
            char_set[val]=true;
        }
        return true;
    }
}
