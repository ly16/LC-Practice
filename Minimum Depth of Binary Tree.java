/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }
        return minRoot(root);
    }
    
    private int minRoot(TreeNode root){
        // To end recursive for the unbalanced tree
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null && root.right == null){
            return 1;
        }
        return Math.min(minRoot(root.left), minRoot(root.right))+1;
    }
}
