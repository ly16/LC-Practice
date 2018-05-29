/*
Given a Binary Search Tree and a target number, return true if there exist two elements 
in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9
Output: True

Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28
Output: False

time = O(n)
space = O(height + n) = O(n) for the list 
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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> bst = new ArrayList<>();
        inorder(root, bst);
        int left = 0;
        int right = bst.size() - 1;
        while (left < right) {
            int sum = bst.get(left) + bst.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> bst) {
        if (root == null) {
            return;
        }
        inorder(root.left, bst);
        bst.add(root.val);
        inorder(root.right, bst);
    }
}

