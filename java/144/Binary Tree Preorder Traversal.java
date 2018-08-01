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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();
        while(s.size()>0||root!=null)
        {
            if(root==null)
            {
                root=s.pop();
                root=root.right;
            }
            else
            {
                res.add(root.val);
                s.push(root);
                root=root.left;
            }
        }
        return res;
    }
}