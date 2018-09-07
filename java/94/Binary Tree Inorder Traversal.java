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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=root;
        while(s.size()>0||p!=null)
        {
            if(p!=null)
            {
                s.push(p);
                p=p.left;
            }
            else
            {
                p=s.pop();
                res.add(p.val);
                p=p.right;
            }
        }
        return res;
    }
}