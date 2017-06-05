/*
Given a binary tree and an integer which is the depth of the target level.

Calculate the sum of the nodes in the target level.

     1
   /   \
  2     3
 / \   / \
4   5 6   7
   /       \
  8         9
For depth = 2, return 5.
For depth = 3, return 22.
For depth = 4, return 17.

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
     * @param root the root of the binary tree
     * @param level the depth of the target level
     * @return an integer
     */
    private int sum=0;
    public int levelSum(TreeNode root, int level) {
        // Write your code
        helper(root,1,level);
        return sum;
    }
    public void helper(TreeNode root, int depth, int level){
        if(root==null){
            return;
        }
        
        if(depth==level){
            sum+=root.val;
        }
        
        helper(root.left, depth+1, level);
        helper(root.right, depth+1,level);
    }
}
