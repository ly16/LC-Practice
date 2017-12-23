/*
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, 
both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

steps:
5>2, 5.left=3,(3,2,5,null)
3>2, 3.left=1,(1,2,5,null),return
2<=3<=5,add 3 to list,(3,2,5,3)
3<5,3.right=4,(4,2,5,3)
4>2, 4.left=null, return
2<=4<=5, add 4 to list,(4,2,5,3 4)
4.right=null, return
2<=5<=5, add 5 to list,(5,2,5,3 4 5)
5.right=8, 8 cannot enter any conditions. So final list is 3 4 5

time = O(n)
space = O(height) = O(n)
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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    helper(root, min, max, result);
    return result;
  }
  
  public List<Integer> helper(TreeNode root, int min, int max, List<Integer> result) {
    if (root == null) {
      return result;
    }
    
    if (root.key > min) {
     helper(root.left, min, max, result);
    }
    
    if (root.key >= min && root.key <= max) {
      result.add(root.key);
    }
    
    if (root.key < max) {
      helper(root.right, min, max, result);
    }
    
    return result;
  }
}
