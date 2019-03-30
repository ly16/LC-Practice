/*
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

example:
Input：
     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
Output：11(it's a TreeNode)


Input：
     1
   /   \
 -5     11
Output：11(it's a TreeNode)
*/

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
     
    // main function
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }
    
     
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
         
        ResultType result = new ResultType(
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
         
        if (subtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}
