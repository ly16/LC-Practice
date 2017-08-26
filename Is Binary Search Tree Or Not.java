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
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); //Integer.MIN_VALUE
  }
  // left smaller, change max; right bigger, change min
  private boolean isBST(TreeNode root, int min, int max){ //int min, int max
    if (root == null){
      return true;
    }
    // TreeNode node.key
    if (root.key < min || root.key > max){
      return false;
    }
     // no duplicate keys, so need + /- 1
    return isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);
  }
}


