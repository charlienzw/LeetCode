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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res=new ArrayList<>();
        if(root==null) return res;
        String s="";
        helper(root,s);
        return res;
    }
    public void helper(TreeNode root,String s)
    {
        
        s=s+root.val+"->";
        if(root.left!=null)
            helper(root.left,s);
        if(root.right!=null)
            helper(root.right,s);
        if(root.left==null&&root.right==null)
            res.add(s.substring(0,s.length()-2));
    }
}