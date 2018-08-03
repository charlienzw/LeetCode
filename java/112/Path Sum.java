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
    boolean b;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
        {
            return false;
        }
        b=false;
        helper(root,0,sum);
        return b;
    }
    public void helper(TreeNode root,int s,int sum)
    {
        
        s=s+root.val;
        if(root.left!=null)
            helper(root.left,s,sum);
        if(root.right!=null)
            helper(root.right,s,sum);
        if(root.left==null&&root.right==null)
        {
            if(s==sum)
                b=true;
        }
    }
}