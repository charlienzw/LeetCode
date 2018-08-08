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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> restb=levelOrder(root);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=restb.size()-1;i>=0;i--) res.add(restb.get(i));
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> resi;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode tmp;
        int qs;
        int flag=0;
        while(true)
        {
            qs=q.size();
            flag=0;
            resi=new ArrayList<>();
            for(int i=0;i<qs;i++)
            {
                tmp=q.poll();
                if(tmp!=null)
                {
                    flag=1;
                    resi.add(tmp.val);
                    q.offer(tmp.left);
                    q.offer(tmp.right);
                }
            }
            if(flag==0)
            {
                break;
            }
            res.add(resi);
        }
        return res;
    }
}