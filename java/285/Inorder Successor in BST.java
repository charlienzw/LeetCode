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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.val == root.val)
        {
            TreeNode right = root.right;
            if(right == null) return null;
            while(right.left != null)
            {
                right = right.left;
            }
            return right;
        }
        else if(p.val > root.val) return inorderSuccessor(root.right, p);
        else
        {
            TreeNode left = inorderSuccessor(root.left, p);
            if(left != null) return left;
            else return root;
        }
    }
}

// Magic method
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null, cur = root;
        while(cur != null)
        {
            if(p.val < cur.val)
            {
                res = cur;
                cur = cur.left;
            }
            else
            {
                cur = cur.right;
            }
        }
        return res;
    }
}