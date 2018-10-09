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
    TreeNode res;
    boolean flag;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)     {
        flag=false;
        boolean b=helper(root,p,q);
        return res;
    }
    public boolean helper(TreeNode root,TreeNode p,TreeNode q)
    {
        if(flag) return false;
        if(root==null) return false;
        if(root.val==p.val)
        {
            if(helper(root.left,p,q)||helper(root.right,p,q))
            {
                res=root;
                flag=true;
                return false;
            }
            else return true;
        }
        if(root.val==q.val) 
        {
            if(helper(root.left,p,q)||helper(root.right,p,q))
            {
                res=root;
                flag=true;
                return false;
            }
            else return true;      
        }
        if(helper(root.left,p,q)&&helper(root.right,p,q)) 
        {
            res=root;
            flag=true;
            return false;
        }
        else 
        {
            return helper(root.left,p,q)||helper(root.right,p,q);
        }
    }
}