/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [5, 3, 8, 11, 4, 1]

Corner Cases
What if the binary tree is null? Return an empty list in this case.
How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
    
    
time =  O(n)
space = O(n) for additional deque
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
  public List<Integer> zigZag(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return new ArrayList<Integer>();
    }
    Deque<TreeNode> deque = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    int layer = 0;
    deque.offerFirst(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        if (layer == 0) {
          TreeNode tmp = deque.pollLast();
          list.add(tmp.key);
          if (tmp.right != null) {
            deque.offerFirst(tmp.right);
          }
          if (tmp.left != null) {
            deque.offerFirst(tmp.left);
          } 
        } else {
          TreeNode tmp = deque.pollFirst();
          list.add(tmp.key);
          if (tmp.left != null) {
            deque.offerLast(tmp.left);
          }
          if (tmp.right != null) {
            deque.offerLast(tmp.right);
          }
        }
      }
      layer = 1 - layer;
    }
    return list;
  }
}



// leetcode version
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        boolean normal = true;
        
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (normal) {
                    TreeNode cur = stack.pollLast();
                    level.add(cur.val);
                    if (cur.left != null) {
                        // offer to the different direction
                        stack.offerFirst(cur.left);
                    }
                    if (cur.right != null) {
                        stack.offerFirst(cur.right);
                    }
                } else {
                    TreeNode cur = stack.pollFirst();
                    level.add(cur.val);
                    if (cur.right != null) {
                        // offer to the different direction
                        stack.offerLast(cur.right);
                    } 
                    if (cur.left != null) {
                        stack.offerLast(cur.left);
                    }
                }
            }
            result.add(level);
            normal = !normal;
        }
        return result;
    }
}
