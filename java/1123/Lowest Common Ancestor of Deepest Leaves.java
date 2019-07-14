/*
    Recursive Function
        The height of current tree
        The number of deepest leaves in current tree
        The depth of current root
    Choose
*/

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
    int maxDepth = 0;
    int cnt = 0;
    int resDepth = -1;
    TreeNode resNode;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        getMaxDepth(root, 0);
        cntMaxDepth(root, 0);
        helper(root, 0);
        return resNode;
        
    }
    
    private void getMaxDepth(TreeNode node, int depth) {
        if (node == null) return;
        maxDepth = Math.max(maxDepth, depth);
        getMaxDepth(node.left, depth + 1);
        getMaxDepth(node.right, depth + 1);
    }
    
    private void cntMaxDepth(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == maxDepth) {
            cnt++;
            return;
        }
        cntMaxDepth(node.left, depth + 1);
        cntMaxDepth(node.right, depth + 1);
    }
    
    private int helper(TreeNode node, int depth) {
        if (node == null) return 0;
        int curCnt = 1;
        if (depth != maxDepth) {
            int leftCnt = helper(node.left, depth + 1);
            int rightCnt = helper(node.right, depth + 1);
            curCnt = leftCnt + rightCnt;
        }
        if (curCnt == cnt) {
            if (depth > resDepth) {
                resDepth = depth;
                resNode = node;
            }
        }
        return curCnt;
    }
}