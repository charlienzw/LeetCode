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
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        cur = dummy;
        helper(root);
        return dummy.right;
    }
    
    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        cur.right = node;
        node.left = null;
        cur = node;
        helper(node.right);
    }
}