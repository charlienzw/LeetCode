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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (postOrder(root, target)) return null;
        return root;
    }
    
    private boolean postOrder(TreeNode node, int target) {
        if (node == null) return true;
        if (postOrder(node.left, target)) node.left = null;
        if (postOrder(node.right, target)) node.right = null;
        if (node.left == null && node.right == null && node.val == target) return true;
        return false;
    }
}