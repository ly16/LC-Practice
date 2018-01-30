/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions
There is parent pointer for the nodes in the binary tree
The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5
The lowest common ancestor of 2 and 9 is 9
The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

time = O(height) = O(n)
space = O(1)
*/

/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    int onel = length(one); //todo
    int twol = length(two);
    if (onel <= twol) {
      return helper(one, two, twol - onel); 
    } else {
      return helper(two, one, onel - twol);
    }
  }
  private TreeNodeP helper(TreeNodeP small, TreeNodeP large, int dif) {
    while (dif > 0) {
      large = large.parent;
      dif--;
    }
    while (small != large) {
      small = small.parent;
      large = large.parent;
    }
    return large;
  }
  
  private int length(TreeNodeP node) {
   int length = 0;
   while (node != null) {
     length++;
     node = node.parent;
   }
   return length;
  }
}
