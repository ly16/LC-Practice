/*
Given a binary tree, return all root-to-leaf paths.
  1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

time = O(n)
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
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, "", result);
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            helper(root.right, path + root.val + "->", result);
        }
    }
}
