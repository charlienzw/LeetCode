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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag;
        if(p!=null&&q!=null)
        {
            if (p.val==q.val)
                flag=true;
            else
                flag=false;    
        }
        else if (p==null&&q==null)
            return true;
        else
            return false;
        
        if(p.left!=null&&q.left!=null)
        {
            flag=flag&&isSameTree(p.left,q.left);
        }
        else if(p.left==null&&q.left==null)
        {
            flag=flag&&true;
        }
        else flag=flag&&false;
        if(p.right!=null&&q.right!=null)
        {
            flag=flag&&isSameTree(p.right,q.right);
        }
        else if(p.right==null&&q.right==null)
        {
            flag=flag&&true;
        }
        else flag=flag&&false;
        return flag;
    }
}