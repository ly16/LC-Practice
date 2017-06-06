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
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result= new ArrayList<String>();
        if(root==null){
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    private void helper(TreeNode root, String path, List <String> result){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            result.add(path);
            return;
        }
        if(root.left!=null){
            helper(root.left, path+"->"+String.valueOf(root.left.val), result);
        }
        if(root.right!=null){
            helper(root.right, path+"->"+String.valueOf(root.right.val), result);
        }
        
    }
}
