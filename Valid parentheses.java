/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
{},[],()
But{3},[.],(a) are not allowed
*/

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        for(Character c: s.toCharArray()){
            if("({[".contains(String.valueOf(c))){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && isValid(stack.peek(), c)){
                   stack.pop();
                }else{
                    //there is no interruption allowed in [a], {,}, etc.
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isValid(char c1,char c2){
        return (c1=='('&& c2==')')||(c1=='{'&& c2=='}')
        ||(c1=='['&&c2==']');
    }
}
