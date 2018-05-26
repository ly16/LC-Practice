/*
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is 
called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
You can use other method to do serializaiton and deserialization.

time = O(n)
space = O(n) for the list needed, and stringbuilder
*/



/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        
        // don't use queue here, for adding null in the list
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node == null) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        
        // remove # at the end of list
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }
        // substring to avoid "{","}"
        String[] vals = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        list.add(root);
        int cur = 0;
        boolean isLeft = true;
        for (int i = 1; i < vals.length; i++) {
            // the left is not null for the first round
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeft) {
                    list.get(cur).left = node;
                } else {
                    list.get(cur).right = node;
                }
                list.add(node);
            }
            if (!isLeft) {
                cur++;
            }
            isLeft = !isLeft;
        }
        return root;
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
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        // queue cannot be null
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        
        for (int i = 0; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            if (cur != null) {
                list.add(cur.left);
                list.add(cur.right);
            }
        }
        
        // remove null at the tail of list
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        // for the ',' sign
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",null");
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        list.add(root);
        int cur = 0;
        boolean left = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (left) {
                    list.get(cur).left = node;
                } else {
                    list.get(cur).right = node;
                }
                list.add(node);
            }
            // current is right, so forward to next layer
            if (!left) {
                cur++;
            }
            left = !left;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
