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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(s1.size()>0||root!=null)
        {
            if(root==null)
            {
                root=s1.pop();
                root=root.left;
            }
            else
            {
                s2.push(root.val);
                s1.push(root);
                root=root.right;
            }
        }
        while(s2.size()>0)
        {
            res.add(s2.pop());
        }
        return res;
    }
}