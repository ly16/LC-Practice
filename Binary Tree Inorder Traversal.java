/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [1,3,2].
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
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    //result is not a symbol in traverse, if we initiate result in inordertraversal
    ArrayList<Integer> result= new ArrayList<>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        traverse(root);
        return result;
    }
    private void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }
}
