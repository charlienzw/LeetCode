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
    boolean flag = true;
    int val;
    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        helper(root);
        return flag;
    }
    public void helper(TreeNode root)
    {
        if(!flag) return;
        if(root != null)
        {
            if(root.val != val) flag = false;
            helper(root.left);
            helper(root.right);
        }
    }
}