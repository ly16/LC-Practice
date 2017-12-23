/*
Check if a given binary tree is symmetric.

Examples

        5

      /    \

    3        3

  /   \    /   \

1      4  4      1

is symmetric.

Corner Cases

What if the binary tree is null? Return true in this case.


time = O(node/2)=O(n)
space = O(height) = O(n) unbalanced = O(logn) balanced

*/



/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public boolean isSymmetric(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return true;
    }
    return symHelper(root.left, root.right);
  }
  
  public boolean symHelper(TreeNode one, TreeNode two) {
    if (one == null && two == null) {
      return true;
    } else if (one == null || two == null) {
      return false;
    } else if (one.key != two.key) {
      return false;
    }
    return symHelper(one.left, two.right) && symHelper(one.right, two.left);
  }
}
