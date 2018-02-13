/*
Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions
The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree

Examples
preorder traversal = {5, 3, 1, 4, 8, 11}
inorder traversal = {1, 3, 4, 5, 8, 11}
the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?
We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:
The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:

    1

  /   \

 2     3

      /

    4


time = O(n)
space = O(height) = O(n)
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
  public TreeNode reconstruct(int[] in, int[] pre) {
    // Write your solution here
    int[] inIndex = new int[]{0};
    int[] preIndex = new int[] {0};
    return helper(in, pre, inIndex, preIndex, Integer.MAX_VALUE);
  }
  public TreeNode helper(int[] in, int[] pre, int[] inIndex, int[] preIndex, int min) {
  	// base case
    if (inIndex[0] >= in.length || in[inIndex[0]] == min) {
    	return null;
    }
    TreeNode root = new TreeNode(pre[preIndex[0]++]);
    root.left = helper(in, pre, inIndex, preIndex, root.key);
    inIndex[0]++;
    root.right = helper(in, pre, inIndex, preIndex, min);
    return root;
  }
}
