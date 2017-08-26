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
    if (root == null){
      return true;
    }
    // if unbalanced return false, balanced return the height
    return helper(root) != -1;
  }
  
  private int helper(TreeNode root){
    if (root == null){
      return 0;
    }
    // check left subtree
    int leftHeight = helper(root.left);
    if(leftHeight == -1){
      return -1;
    }
    // check right subtree
    int rightHeight = helper(root.right);
    if(rightHeight == -1){
      return -1;
    }
    
    if(Math.abs(leftHeight - rightHeight) > 1){
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
