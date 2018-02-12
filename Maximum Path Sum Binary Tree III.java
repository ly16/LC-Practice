/*
Given a binary tree in which each node contains an integer number. 
Find the maximum possible subpath sum(both the starting and ending node of 
the subpath should be on the same path from root to one of the leaf nodes, 
and the subpath is allowed to contain only one node).

Assumptions
The root of given binary tree is not null

Examples
   -5

  /    \

2      11

     /    \

    6     14

           /

        -3

The maximum path sum is 11 + 14 = 25

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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  public int helper(TreeNode root, int[] max) {
  	// base case
    if (root ==  null) {
    	return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    int subSum = Math.max(Math.max(left, right), 0) + root.key;
    max[0] = Math.max(subSum, max[0]);
    return subSum;
  }
}

