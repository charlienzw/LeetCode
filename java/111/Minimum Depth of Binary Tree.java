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
    int s;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        s=Integer.MAX_VALUE;
        helper(root,0);
        return s;
    }
    public void helper(TreeNode root,int cnt)
    {
        cnt++;   
        if(root.left!=null)
            helper(root.left,cnt);
        if(root.right!=null)
            helper(root.right,cnt);
        if(root.left==null&&root.right==null)
        {
            s=Math.min(s,cnt);
        }
    }
}