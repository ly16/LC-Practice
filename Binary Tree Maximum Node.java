/*
Find the maximum node in a binary tree, return the node.
Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   3 -4  -5 
return the node with value 3.
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if(root==null){
            return root;
        }
        TreeNode left= maxNode(root.left);
        TreeNode right= maxNode(root.right);
        return findMax(root, findMax(left, right));
        
    }
    
    private TreeNode findMax(TreeNode a, TreeNode b){
        if(a == null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.val > b.val){
            return a;
        }else{
            return b;
        }
    }
}
