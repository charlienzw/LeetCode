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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> resi;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode tmp;
        int qs;
        while (true) {
            qs = q.size();
            resi = new ArrayList<>();
            for (int i = 0; i < qs; i++) {
                tmp = q.poll();
                if (tmp != null) {
                    resi.add(tmp.val);
                    q.offer(tmp.left);
                    q.offer(tmp.right);
                }
            }
            if (q.size() == 0) break;
            res.add(resi);
        }
        return res;
    }
}