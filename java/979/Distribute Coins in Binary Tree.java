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
    int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    
    private int helper(TreeNode node) {
        //  return the excess number of coins in the subtree at or below this node
        if (node == null) return 0;
        int L = helper(node.left);
        int R = helper(node.right);
        res += Math.abs(L) + Math.abs(R);
        return L + R + node.val - 1;
    }
}