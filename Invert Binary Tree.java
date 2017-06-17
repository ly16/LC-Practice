/*
Invert a binary tree.
Example
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4

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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root==null){
            return;
        }
        //exchange left and right
        TreeNode t=root.right;
        root.right=root.left;
        root.left=t;
        
        invertBinaryTree(root.right);
        invertBinaryTree(root.left);
    }
}
