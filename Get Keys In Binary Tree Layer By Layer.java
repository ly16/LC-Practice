/*
Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.


Examples

        1

      /    \

    2        3

  /   \        \

 4     5        6

the result is [ [1], [2, 3], [4, 5, 6] ]

Steps:
queue           cur          curLayer          list
1              
2 3               1             1               1
2                 2             2               
4 5               3             2 3             1 2 3
4 5 6             4             4
5 6               5             4 5 
6                 6             4 5 6           1 2 3 4 5 6 



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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // Write your solution here.
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(root == null){
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>(); //TreeNode
    queue.offer(root);
    
    while(!queue.isEmpty()){
      List<Integer> curLayer = new ArrayList<>();
      int size = queue.size();  //size()
      
      for(int i = 0; i < size; i++){
        TreeNode cur = queue.poll();
        curLayer.add(cur.key);  //treenode node.key
        if(cur.left != null){
          queue.offer(cur.left);
        }
        if(cur.right != null){
          queue.offer(cur.right);
        }
      }
      
      list.add(curLayer);
    }
    return list;
  }
}
