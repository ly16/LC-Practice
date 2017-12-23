/*
Implement an iterative, pre-order traversal of a given binary tree, 
return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        1

      /    \

    2        3

  /   \        

4      5       

Pre-order traversal is [1, 2, 4, 5, 3]
Steps:
stack preOrder
1    ->  1
3 2  ->  1 2
3 5 4 -> 1 2 4
3 5 ->  1 2 4 5
3   -> 1 2 4 5 3

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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    while(!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
      result.add(cur.key);
    }
    return result;
  }
}
