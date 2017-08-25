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
null            3                5
null           3 1                5
null     3.left=null             5 
null     3.right=null            5
null        3  1 4               5
null     4.left=null             5
null     4.right=null            5
null 
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
