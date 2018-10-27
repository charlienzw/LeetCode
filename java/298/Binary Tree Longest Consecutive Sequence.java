//Time: O(n)
//Space: O(n)

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
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        res = 0;
        int rootval = helper(root);
        return Math.max(res, rootval);
    }
    public int helper(TreeNode root)
    {
        int rootval = 1;
        if(root.left != null)
        {
            if(root.left.val != root.val + 1)
            {
                int leftval = helper(root.left);
                res = Math.max(res, leftval);
            }
            else
            {
                rootval = Math.max(rootval, helper(root.left) + 1); 
            }
        }
        if(root.right != null)
        {
            if(root.right.val != root.val + 1)
            {
                int rightval = helper(root.right);
                res = Math.max(res, rightval);
            }
            else
            {
                rootval = Math.max(rootval, helper(root.right) + 1); 
            }
        }        
        return rootval;
    }
}