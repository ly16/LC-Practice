/*
Delete the target key K in the given binary search tree if the binary search tree contains K. 
Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree, 
after deletion the binary search tree's property should be maintained.

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
  public TreeNode delete(TreeNode root, int key) {
    // Write your solution here
    if (root == null) {
    	return root;
    }
    if (key == root.key) {
    	if (root.left == null) {
      	return root.right;
      } else if (root.right == null) {
      	return root.left; 
      } else if (root.right.left == null) {
      	root.right.left = root.left;
        return root.right;
      } else {
      	TreeNode newRoot = deleteSmallest(root.right);	
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    }
    if (root.key < key) {
    	root.right = delete(root.right, key);
    } else {
    	root.left = delete(root.left, key);
    }
    return root;
  }
  
  private TreeNode deleteSmallest(TreeNode root) {
  	while (root.left.left != null) {
    	root = root.left;
    }
    TreeNode smallest = root.left;
    root.left = root.left.right;
    return smallest;
  }
}
