/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
   
   
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = post[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                index = i;
                break;
            }
        }
        int len = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(in, inStart, index - 1, post, postStart, postStart + len - 1);
        root.right = helper(in, index + 1, inEnd, post, postStart + len, postEnd - 1);
        return root;
    }
}
