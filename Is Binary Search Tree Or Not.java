/*
Determine if a given binary tree is binary search tree.

There are no duplicate keys in binary search tree.
You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

What if the binary tree is null? Return true in this case.

time = O(n)
space = O(height) = O(n) unbalanced
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
  public boolean isBST(TreeNode root) {
    // Write your solution here.
    return BSThelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  public boolean BSThelper(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.key < min || root.key > max) {
      return false;
    }
    return BSThelper(root.left, min, root.key - 1) && BSThelper(root.right, root.key + 1, max);
  }
}


