/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

Notice
node A or node B may not exist in tree.

Example
For the following binary tree:
  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4
LCA(5, 6) = 7
LCA(6, 7) = 7


time = O(n)
space = O(1)
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
    public class ReturnType {
        public boolean AExist, BExist;
        public TreeNode result;
        ReturnType(boolean AExist, boolean BExist, TreeNode result) {
            this.AExist = AExist;
            this.BExist = BExist;
            this.result = result;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ReturnType rt = helper(root, A, B);
        if (rt.AExist & rt.BExist) {
            return rt.result;
        }
        return null;
    }
    
    private ReturnType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ReturnType(false, false, null);
        }
        
        ReturnType leftRt = helper(root.left, A, B);
        ReturnType rightRt = helper(root.right, A, B);
        
        boolean AExist = leftRt.AExist || rightRt.AExist || root == A;
        boolean BExist = leftRt.BExist || rightRt.BExist || root == B;
        
        if (root == A || root == B) {
            return new ReturnType(AExist, BExist, root);
        }
        
        if (leftRt.result != null && rightRt.result != null) {
            return new ReturnType(AExist, BExist, root);
        }
        if (leftRt.result != null) {
            return new ReturnType(AExist, BExist, leftRt.result);
        }
        if (rightRt.result != null) {
            return new ReturnType(AExist, BExist, rightRt.result);
        }
        return new ReturnType(AExist, BExist, null);
    }
}
