/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example
Given root = {1,#,2}, k = 2, return 2.

in-order dfs traversal -> ascending order -> get the kth smallest
time = O(n)     
space = O(height) = O(logn)
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
    private int count = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        // in-order traverse
        count = k;
        helper(root);
        return result;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root.left);
        count--;
        if (count == 0) {
            result = root.val;
        }
        helper(root.right);
    }
}
