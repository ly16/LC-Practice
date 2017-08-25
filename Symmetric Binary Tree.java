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
    if (root == null){
      return true;
    }
    return isSymmetric(root.left, root.right);
  }
  
  private boolean isSymmetric(TreeNode left, TreeNode right){
    // 1. all null 2. one null 3. key is not equal
    if (left == null && right == null){
      return true;
    } else if (left == null || right == null){
      return false;
    } else if (left.key != right.key){
      return false;
    }
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }
}
