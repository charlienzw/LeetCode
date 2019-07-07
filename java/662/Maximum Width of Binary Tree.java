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
    Map<Integer, Integer> depth2Pos; 
    public int widthOfBinaryTree(TreeNode root) {
        res = 0;
        depth2Pos = new HashMap<>();
        helper(root, 0, 0);
        return res;
    }
    
    private void helper(TreeNode root, int depth, int pos) {
        if (root == null) return;
        if (!depth2Pos.containsKey(depth)) depth2Pos.put(depth, pos);
        res = Math.max(res, pos - depth2Pos.get(depth) + 1);
        helper(root.left, depth + 1, 2 * pos);
        helper(root.right, depth + 1, 2 * pos + 1);
    }
}