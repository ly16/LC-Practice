/*
The given sequence is not null
There are no duplicate keys in the binary search tree

Examples
postorder traversal = {1, 4, 3, 11, 8, 5}
the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?
We use the pre order traversal sequence with a special symbol "#" denoting the null node.
For Example:
The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

    1

  /   \

 2     3

      /

    4


time = O(n)
space = O(height) = O(log(n))
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
  public TreeNode reconstruct(int[] post) {
    // Write your solution here
    int[] index = new int[]{post.length - 1};
    return helper(post, index, Integer.MIN_VALUE);
  }
  
  public TreeNode helper(int[] post, int[] index, int min) {
  	// base case
    if (index[0] < 0 || post[index[0]] <= min) {
    	return null;
    }
    TreeNode root = new TreeNode(post[index[0]--]);
    root.right = helper(post, index, root.key);
    root.left = helper(post, index, min);
    return root;
  }
}

