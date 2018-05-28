/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example
Given:

    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].


time = O(n)
space = O(height) = O(n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // recursive version:
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper(root, result);
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
        return result;
    }
}

