/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along 
the longest path from the root node down to the farthest leaf node.

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.


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
    private int maxDepth;
    public int maxDepth(TreeNode root) {
        // write your code here
        maxDepth=0;
        helper(root,1);
        return maxDepth;
    }
    
    private void helper(TreeNode root, int depth){
        if(root==null){
            return;
        }
        maxDepth=Math.max(maxDepth,depth);
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}
