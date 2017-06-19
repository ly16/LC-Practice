/**
*Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.
*Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7
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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        int length= A.length;
        TreeNode root=null;
        root = recursion(A, 1, length, root);
        A=null;
        return root;
    }  
    
    public TreeNode recursion(int[] array, int lhs, int rhs, TreeNode root){
        if(lhs <= rhs){
            //avoid for overflow
            int mid = rhs+ (lhs - rhs)/2;  
            root = new TreeNode(array[mid-1]);
            root.left = recursion(array, lhs, mid-1,root.left);
            root.right= recursion(array, mid+1, rhs, root.right);
        }
        return root;
    }
}
