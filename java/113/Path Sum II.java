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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res=new ArrayList<>();
        if(root==null) return res;
        helper(root,0,new ArrayList<>(),sum);
        return res;
    }
    public void helper(TreeNode root,int s,List<Integer> l,int sum)
    {
        s=s+root.val;
        l.add(root.val);
        if(root.left!=null)
            helper(root.left,s,l,sum);
        if(root.right!=null)
            helper(root.right,s,l,sum);
        if(root.left==null&&root.right==null)
        {
            if(s==sum)
                res.add(new ArrayList<>(l));
        }
        l.remove(l.size()-1);
    }
}