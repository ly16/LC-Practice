/*
Implement an iterative, post-order traversal of a given binary tree, 
return the list of keys of each node in the tree as it is post-order traversed.
left, right, root

Example:
        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]
What if the given binary tree is null? Return an empty list in this case.

Steps:
cur           stack             list
5
null           3 8               5
8              8.left=null       5 8
8              3 11              5 8
11             3                 5 8 11
3              1  4              5 8 11 3
4              1                 5 8 11 3 4
1              null              5 8 11 3 4 1
reverse：1 4 3 11 8 5
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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here.
   List<Integer> list = new ArrayList<>();
   if (root == null){
     return list;
   }
   // reverse root, right, left -> left, right, root
   Deque<TreeNode> stack = new LinkedList<TreeNode>();  //LinkedList 
   stack.offerFirst(root);
   while(!stack.isEmpty()){             // stack.isEmpty() 
     TreeNode cur = stack.pollFirst();
     list.add(cur.key);               // cur.key
     // left in the stack first
     if (cur.left != null){
       stack.offerFirst(cur.left);
     }
     if (cur.right !=null){
       stack.offerFirst(cur.right);
     }
   }
   // reverse to left, right, root postOrder
   Collections.reverse(list);      //collections, not collection
   return list;
  }
}
