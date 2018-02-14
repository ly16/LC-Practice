/*
Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.

Assumptions
l, m, n >= 0

Examples
l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", ""]


time = O(4^(2*l+2*m+2*n))
space = O(2*l+2*m+2*n)
*/

public class Solution {
  private static final char[] ps = new char[] {'(',')', '[', ']', '{', '}'};
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    int[] remain = new int[] {l, l, m, m, n, n};
    int targetLen = 2 * l + 2 * m + 2 * n;
    StringBuilder cur = new StringBuilder();
    Deque<Character> stack = new LinkedList<>();
    List<String> result = new ArrayList<>();
    helper(remain, targetLen, cur, stack, result);
    return result;
  }
  private void helper(int[] remain, int targetLen, StringBuilder cur, Deque<Character> stack, List<String> result) {
  	if (cur.length() == targetLen) {
    	result.add(cur.toString());
      return;
    }
    for (int i = 0; i < remain.length; i++) {
    	if (i % 2 == 0) {
      	if (remain[i] > 0) {
        	cur.append(ps[i]);
          stack.offerFirst(ps[i]);
          remain[i]--;
          helper(remain, targetLen, cur, stack, result);
          cur.deleteCharAt(cur.length() - 1);
          stack.pollFirst();
          remain[i]++;
        }
      } else {
      	if (!stack.isEmpty() && stack.peekFirst() == ps[i - 1]) {
        	cur.append(ps[i]);
          stack.pollFirst();
          remain[i]--;
          helper(remain, targetLen, cur, stack, result);
          cur.deleteCharAt(cur.length() - 1);
          stack.offerFirst(ps[i - 1]);
          remain[i]++;
        }
      }
    }
  }
}
