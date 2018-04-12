/*
In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:
The given root is not null.
There are no duplicate keys in the binary search tree.

Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5
closest number to 10 is 11
closest number to 6 is 6

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4





time = O(height) = O(n)
space = O(1)
*/



/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

public class Solution {
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int closest = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            }
            if (Math.abs(root.key- target) < Math.abs(closest - target)) {
                closest = root.key;
            } 
            if (root.key < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return closest;
    }
}



