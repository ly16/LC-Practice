/*
Implement an upper method to convert all characters in a string to uppercase.
You should ignore the characters not in alphabe
Given "abc", return "ABC".

Given "aBc", return "ABC".

Given "abC12", return "ABC12".
*/

public class Solution {
  
    public String lowercaseToUppercase2(String str) {
        //Write your code here
        StringBuilder sb=new StringBuilder(str);
        
        for(int i=0;i<sb.length();i++)
        {
            char a=sb.charAt(i);//character
            if(Character.isLowerCase(a))
            {
                sb.setCharAt(i,Character.toUpperCase(a));replace
            }
        }
        return sb.toString();
    }
}
