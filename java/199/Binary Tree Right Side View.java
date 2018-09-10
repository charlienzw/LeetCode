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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        TreeNode p=root;
        q1.offer(p);
        while(true)
        {
            if(q1.size()==0) break;
            res.add(q1.peek().val);
            while(q1.size()>0)
            {
                p=q1.poll();
                if(p.right!=null)
                {
                    q2.offer(p.right);
                }
                if(p.left!=null)
                {
                    q2.offer(p.left);
                }
            }
            if(q2.size()==0) break;
            res.add(q2.peek().val);
            while(q2.size()>0)
            {
                p=q2.poll();
                if(p.right!=null)
                {
                    q1.offer(p.right);
                }
                if(p.left!=null)
                {
                    q1.offer(p.left);
                }
            }             
        }
        return res;
    }
}