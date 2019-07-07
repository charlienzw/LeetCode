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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        helper(root, p, q);
        return res;
    }
    
    private boolean helper(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return false;
        int leftRes = helper(cur.left, p, q) ? 1 : 0;
        int rightRes = helper(cur.right, p, q) ? 1 : 0;
        int curRes = (cur == p || cur == q) ? 1 : 0;
        if (leftRes + rightRes + curRes >= 2) res = cur;
        return leftRes + rightRes + curRes > 0;
    }
}