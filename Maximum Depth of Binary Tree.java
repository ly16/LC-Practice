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

time = O(n)
space = O(n)
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

// Traverse version, void usually so that we need a global variable
public class Solution {
    public int depth;
    public int maxDepth(TreeNode root) {
        // write your code here
        depth = 0;
        traverse(root, 1);
        return depth;
    }
    
    private void traverse(TreeNode node, int curDepth) {
        if (node == null) {
            return;
        }
        depth = Math.max(depth, curDepth);
        traverse(node.left, curDepth + 1);
        traverse(node.right, curDepth + 1);
    }
}



// Divide & conquer (better), need return value
public class Solution {
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
