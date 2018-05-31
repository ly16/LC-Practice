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


//leetcode version
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] {0};
        int[] inIndex = new int[] {0};
        return helper(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int[] preIndex, int[] inIndex, int target) {
        if (inIndex[0] >= inorder.length || inorder[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]++]);
        root.left = helper(preorder, inorder, preIndex, inIndex, root.val);
        inIndex[0]++;
        root.right = helper(preorder, inorder, preIndex, inIndex, target);
        return root;
    }
}


// index version
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length - 1;
        int inLen = inorder.length - 1;
        return helper(preorder, 0, preLen, inorder, 0, inLen);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int len = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preStart + 1, preStart + len, inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + len + 1, preEnd, inorder, index + 1, inEnd);
        
        return root;
    }
}
