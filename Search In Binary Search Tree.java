/*
Find the target key K in the given binary search tree, 
return the node that contains the key if K is found, otherwise return null.

Assumptions
There are no duplicate keys in the binary search tree

time = O(height)
space = O(height)
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
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    if (root == null || root.key == key) {
    	return root;
    }
    return root.key > key ? search(root.left, key) : search(root.right, key);
  }
}
