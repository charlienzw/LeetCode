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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode p;
        p = root.right;
        flatten(root.left);
        root.right = root.left;
        TreeNode q = root;
        while(q.right != null)
        {
            q = q.right;
        }
        flatten(p);
        q.right = p;
        root.left = null;   
    }
}