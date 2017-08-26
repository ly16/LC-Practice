/*
Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. 
A tweak is defined as a swap of the children of one node in the tree.

Examples

        5

      /    \

    3        8

  /   \

1      4

and

        5

      /    \

    8        3

           /   \

          1     4

the two binary trees are tweaked identical.
time = 4^height = 4^log_2(n) = O(n^2) for balanced
time = 4^height = 4^n = O(2^n) for unbalanced
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
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // Write your solution here.
    if(one == null && two == null){
      return true;
    } else if (one ==null || two == null){
      return false;
    } else if (one.key != two.key){
      return false;
    }
    // 2 conditions: identity or Tweaked Identical
    return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
    || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
  }
}
