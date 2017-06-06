/*
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        ArrayList<Integer> path= new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }
    
    public void helper(TreeNode root,  ArrayList<Integer> path, int sum,
    int target, List<List<Integer>> result){
        // if(root==null){
        //     return;
        // }
        //meet leaf
        if(root.left==null && root.right==null){
            if(sum==target){
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        //go left
        if(root.left!=null){
            path.add(root.left.val);
            helper(root.left, path, sum+root.left.val,target, result);
            path.remove(path.size()-1);//remove the path to original form
        }
        //go right
        if(root.right!=null){
            path.add(root.right.val);
            helper(root.right, path, sum+root.right.val, target,result);
             path.remove(path.size()-1);
        }
        
    }
}
