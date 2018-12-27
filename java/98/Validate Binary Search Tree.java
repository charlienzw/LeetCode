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
    boolean prune = false; // Prune to make more efficient
    public boolean isValidBST(TreeNode root) {
        return helper(root, "#", "#"); // Prevent corner case: if there is a node whose value is MAX_VALUE then return false but should return true
    }
    public boolean helper(TreeNode root, String low, String high) {
        if(prune) return false;
        if(root != null)
        {
            if(root.left != null && (root.val <= root.left.val || !high.equals("#") && Integer.valueOf(high) <= root.left.val || !low.equals("#") && Integer.valueOf(low) >= root.left.val))
            {
                prune = true;
                return false;
            }
            if(root.right != null && (root.val >= root.right.val || !high.equals("#") && Integer.valueOf(high) <= root.right.val || !low.equals("#") && Integer.valueOf(low) >= root.right.val))
            {
                prune = true;
                return false;
            }
            return helper(root.left, low, root.val + "") && helper(root.right, root.val + "", high);
        }
        else return true;
    }
}