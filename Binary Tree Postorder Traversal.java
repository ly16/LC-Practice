/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?

time = O(n)
space = O(height) = O(n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// recursive version
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root  == null) {
            return result;
        }
        return helper(root, result);
    }
    private List<Integer> helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
        return result;
    }
}


// iterative version
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        
        while (!stack.isEmpty()) {
            // left, right, root -> root, right, left -> root, left, right
            TreeNode cur = stack.pollFirst();
            result.add(cur.val);
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
