/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//time: O(n) each node one operation
//space: O(n) if one line tree, then n stack
class Solution {
    int maxlength=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxlength;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        maxlength=Math.max(maxlength,left+right);
        return Math.max(left,right)+1;
    }
} 