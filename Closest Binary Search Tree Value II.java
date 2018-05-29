/*
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Example:
Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

time = O(logn) = O(height)
space = O(n) for the stack
*/

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> succ = new LinkedList<>();
        Deque<TreeNode> pred = new LinkedList<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peekFirst().val == pred.peekFirst().val) {
            getNextPredecessor(pred); //only left one side
        }
        for (int i = 0; i < k; i++) {
            if(succ.isEmpty()) {
                ret.add(getNextPredecessor(pred));
            } else if(pred.isEmpty()) {
                ret.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double)succ.peek().val - target);
                double pred_diff = Math.abs((double)pred.peek().val - target);
                if(succ_diff < pred_diff) {
                    ret.add(getNextSuccessor(succ));
                } else {
                    ret.add(getNextPredecessor(pred));
                }
            }
        }
        return ret;
    }

    private void initializeSuccessorStack(TreeNode root, double target, Deque<TreeNode> succ) {
        while(root != null) {
            if(root.val == target) {
                succ.offerFirst(root);
                break;
            } else if(root.val > target) {
                succ.offerFirst(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void initializePredecessorStack(TreeNode root, double target, Deque<TreeNode> pred) {
        while(root != null){
            if(root.val == target){
                pred.offerFirst(root);
                break;
            } else if(root.val < target){
                pred.offerFirst(root);
                root = root.right;
            } else{
                root = root.left;
            }
        }
    }
    
    private int getNextSuccessor(Deque<TreeNode> succ) {
        TreeNode curr = succ.pollFirst();
        int ret = curr.val;
        curr = curr.right;
        while(curr != null) {
            succ.offerFirst(curr);
            curr = curr.left;
        }
        return ret;
    }

    private int getNextPredecessor(Deque<TreeNode> pred) {
        TreeNode curr = pred.pollFirst();
        int ret = curr.val;
        curr = curr.left;
        while(curr != null) {
            pred.offerFirst(curr);
            curr = curr.right;
        }
        return ret;
    }
}
