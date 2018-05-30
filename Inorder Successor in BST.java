/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Note: If the given node has no in-order successor in the tree, return null.

Example 1:
Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2


Example 2:
Input: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /   
1
Output: null

time = O(logn)
space = O(1)
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
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        // find the target
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        // not find or root == null at the beginning
        if (root == null) {
            return null;
        }
        // root == target
        if (root.right == null) {
            return result;
        } else {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }
}
