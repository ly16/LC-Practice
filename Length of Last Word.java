/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
return the length of last word in the string.

If the last word does not exist, return 0.

A word is defined as a character sequence consists of non-space characters only.

Example
Given s = "Hello World", return 5.
*/


public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        int length=0;
        char[] chars=s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            //before the first char
            if(length==0){
                if(chars[i]==' '){
                    continue;
                }else{
                    length++;
                }
                //after the first char
            }else{
                if(chars[i]==' '){
                    break;
                }else{
                    length++;
                }
            }
        }
        return length;
    }
}

