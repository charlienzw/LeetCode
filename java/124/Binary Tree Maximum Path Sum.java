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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int x=helper(root);
        res=Math.max(res,x);
        return res;
    }
    public int helper(TreeNode root)
    {
        if(root==null) return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        int x=Math.max(Math.max(root.val,root.val+left),root.val+right);
        res=Math.max(res,x);
        res=Math.max(res,root.val+left+right);
        return x;
    }
}