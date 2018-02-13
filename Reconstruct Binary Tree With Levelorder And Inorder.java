/*
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions
The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree

Examples
levelorder traversal = {5, 3, 8, 1, 4, 11}
inorder traversal = {1, 3, 4, 5, 8, 11}
the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?
We use  level order traversal sequence with a special symbol "#" denoting the null node.
For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1

  /   \

 2     3

      /

    4


time = O(n + n-1 + n-2 +... + 1) = O(n^2)
space = O(n^2)
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
  public TreeNode reconstruct(int[] in, int[] level) {
    // Write your solution here
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
    	inMap.put(in[i], i);
    }
    List<Integer> levelList = new ArrayList<>();
    for (int num : level) {
    	levelList.add(num);
    }
    return helper(inMap, levelList);
  }
  public TreeNode helper(Map<Integer, Integer> inMap, List<Integer> levelList) {
  	// base case
    if (levelList.isEmpty()) {
    	return null;
    }
    TreeNode root = new TreeNode(levelList.remove(0));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int num : levelList) {
    	if (inMap.get(num) < inMap.get(root.key)) {
      	left.add(num);
      } else {
      	right.add(num);
      }
    }
    root.left = helper(inMap, left);
    root.right = helper(inMap, right);
    return root;
  }
}
