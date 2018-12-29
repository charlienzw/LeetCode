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
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode root)
    {
        if(root==null) return true;
        return helper(root.left)&&helper(root.right)&&(Math.abs(height(root.left)-height(root.right))<=1);
    }
    public int height(TreeNode root)
    {
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    
    
}

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
    boolean stop = false;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return !stop;
    }
    
    public int helper(TreeNode root)
    {
        if(stop) return 0;
        if(root != null)
        {
            int leftdepth = helper(root.left);
            int rightdepth = helper(root.right);
            if(Math.abs(leftdepth - rightdepth) >= 2)
            {
                stop = true;
            }
            return Math.max(leftdepth, rightdepth) + 1;
        }
        else
        {
            return 0;
        }
    }
}