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
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        if(root.left!=null&&root.left.val>=root.val||root.right!=null&&root.right.val<=root.val) return false;
        else return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root,int start,int end)
    {
        if(root.left!=null&&(root.left.val>end||root.left.val<start||root.left.val>=root.val)||root.right!=null&&(root.right.val>end||root.right.val<start||root.right.val<=root.val))
        {
            return false;
        }
        else
        {
            return (root.left==null?true:helper(root.left,start,root.val-1))&&(root.right==null?true:helper(root.right,root.val+1,end));
        }
    }
}