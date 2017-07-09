/*
For the given binary tree, return a deep copy of it.
Example
Given a binary tree:

     1
   /  \
  2    3
 / \
4   5
return the new binary tree with same structure and same value:
     1
   /  \
  2    3
 / \
4   5
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
    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if(root==null){
            return null;
        }
        TreeNode croot= new TreeNode(root.val);
        croot.left= cloneTree(root.left);
        croot.right= cloneTree(root.right);
        return croot;
    }
}
