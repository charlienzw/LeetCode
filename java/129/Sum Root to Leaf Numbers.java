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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sum=0;
        String s="";
        helper(root,s);
        return sum;
    }
    public void helper(TreeNode root,String s)
    {
        s=s+root.val;
        if(root.left!=null)
            helper(root.left,s);
        if(root.right!=null)
            helper(root.right,s);
        if(root.left==null&&root.right==null)
        {
            sum=sum+Integer.valueOf(s);
        }
    }
}