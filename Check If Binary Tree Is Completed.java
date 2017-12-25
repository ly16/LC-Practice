/*
Check if a given binary tree is completed. 
A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. 
Furthermore, all nodes are as far left as possible.


What if the binary tree is null? Return true in this case.

1. miss left child but not right child
2. miss right child, but not the end

Example
        1

      /    \

    2        3

  /   \       \

4      5        6 
is not a complete tree.

Steps:
Queue         cur           flag
1                            false
2 3            1             false
3 4 5          2             false
4 5            3             true
3.left flag = true
return false

time = O(n)
space = O(n)    // extra queue
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
  public boolean isCompleted(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    boolean flag = false;
    
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur.left == null) {
        flag = true;
      } else if (flag) {
        return false;
      } else {
        queue.offer(cur.left);
      }
      
      if (cur.right == null) {
        flag = true;
      } else if(flag) {
        return false;
      } else {
        queue.offer(cur.right);
      }
    }
    return true;
  }
}

