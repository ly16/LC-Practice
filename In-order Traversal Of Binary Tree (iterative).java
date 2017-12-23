/*
Implement an iterative, in-order traversal of a given binary tree, 
return the list of keys of each node in the tree as it is in-order traversed.

Examples

        4

      /    \

    2        5

  /   \        

1      3        

In-order traversal is [1, 2, 3, 4, 5]

Steps:
cur             stack   inOrder
4                4
2               4 2
1              4 2 1
1.left=null     4 2        1
1.right=null     4        1 2 
2.right=3       4 3       1 2
3.left=null      4        1 2 3
3.right=null     4       1 2 3 4
4.right=5         5      1 2 3 4
5.left=null       5    1 2 3 4 5
5.right=null    null

time = O(n), n is # of node
space = O(n)
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
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    TreeNode cur = root;
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      } else {
        cur = stack.pollFirst();
        result.add(cur.key);
        cur = cur.right;
      }
    }
    
    return result;
  }
}

