/*
Check if a given binary tree is balanced. 
A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
Example:
        5

      /    \

    3        8

  /   \        \

1      4        11

is balanced binary tree
What if the binary tree is null? Return true in this case.
time = O(nlogn), each level O(n), logn levels
space = O(log(n))
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
  public boolean isBalanced(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return true;
    }
    return getHeight(root) != -1;
  }
  
  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    if (left == -1) {
      return -1;
    }
    
    int right = getHeight(root.right);
    if (right == -1) {
      return -1;
    }
    
    if (Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(right, left) + 1;
  }
}
