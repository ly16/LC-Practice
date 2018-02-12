/*
Given a binary tree in which each node contains an integer number.
Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), 
the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.
If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
If target = 10, There does not exist any paths sum of which is target.
If target = 11, There exists a path only containing the node 11.

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.
For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
    
    
time = O(n)
space = O(height) = O(n)
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
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if (root == null) {
    	return false;
    }
    Set<Integer> fixSum = new HashSet<>();
    fixSum.add(0);
    return helper(root, target, 0, fixSum);
  }
  private boolean helper(TreeNode root, int target, int prevSum, Set<Integer> fixSum) {
  	prevSum += root.key;
    if (fixSum.contains(prevSum - target)) {
    	return true;
    }
    boolean needRemove = fixSum.add(prevSum);
    if (root.left != null && helper(root.left, target, prevSum, fixSum)) {
    	return true;
    }
    if (root.right != null && helper(root.right, target, prevSum, fixSum)) {
    	return true;
    }
    
    if (needRemove) {
    	fixSum.remove(prevSum);
    }
    return false;
  }
}
