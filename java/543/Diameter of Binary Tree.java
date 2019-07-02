/*
    Preorder Traversal
        if one node has two children
            update the result with left child height plus right child height
            set the node's height to the maximun of left and right child height plus one
/*

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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        res = Math.max(res, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}