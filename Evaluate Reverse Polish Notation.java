/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Assumption
Valid operators are +, -, , /.
Each operand may be an integer or another expression.

Examples
["2", "1", "+", "3", ""] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

time = O(n)
space = O(n)  for deque
*/

public class Solution {
  public int evalRPN(String[] tokens) {
    // Write your solution here
   	Deque<Integer> stack = new LinkedList<>();
    String s = "+-*/";
    for (String token : tokens) {
    	if (!s.contains(token)) {
      	stack.offerFirst(Integer.valueOf(token));
        continue;
      } 
      int a = stack.pollFirst();
      int b = stack.pollFirst();
      if (token.equals("+")) {
      	stack.offerFirst(b + a);
      } else if (token.equals("-")) {
      	stack.offerFirst(b - a);
      } else if (token.equals("*")) {
      	stack.offerFirst(b * a);
      } else {
      	stack.offerFirst(b / a);
      }
    }
    return stack.pollFirst();
  }
}
