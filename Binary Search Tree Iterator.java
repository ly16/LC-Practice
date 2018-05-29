/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

steps:
       5
      /  \
    2     6
   /  \
 1     4
      /
    3
 
stack: 5,2,1  => 5,2
stack: 5,2 => 5 => 5,4  next = 3
      5,4,3
stack: 5,4,3 => 5,4 => 5  next = 6
      6
stack:6 => null

time = O(1) on average
space = O(height) = O(n) for the deque
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class BSTIterator {
    private Deque<TreeNode> stack = new LinkedList<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pollFirst();
        TreeNode next = tmp.right;
        while (next != null) {
            stack.offerFirst(next);
            next = next.left;
        }
        return tmp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
