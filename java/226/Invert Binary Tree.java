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
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
        if (root!=null)
        {
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}