/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/
public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if(s== null||s.length()==0)
        {
            return true;
        }
        
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            while(i<s.length() && !isValid((s.charAt(i)))) //if not character, read next position
            {
                i++;
            }
            if (i==s.length()) return true; //if no char
            
            while(j>=0 && !isValid(s.charAt(j)))
            {
                j--;
            }
            //compare two char
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) break;
            else{
                i++;
                j--;
            }
        }
        
        
        return j<=i;//odd =, even<
        
    }
    
    private boolean isValid(char c)
    {
        return Character.isLetter(c) ||Character.isDigit(c);
    }
}
