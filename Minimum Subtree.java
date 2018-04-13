/*
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example
Given a binary tree:
     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.

time = O(n^2)
space = O(height) = O(n)
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
    private TreeNode minRoot = null;
    private int min = Integer.MAX_VALUE; 
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        helper(root);
        return minRoot;
    }
    private int helper(TreeNode root) {
        if (root == null){
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum < min) {
            min = sum;
            minRoot = root;
        }
        return sum;
    }
}
