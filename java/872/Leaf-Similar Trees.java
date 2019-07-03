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
    List<Integer> leaves;
    boolean isSame = true;
    int cur = 0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leaves = new ArrayList<>();
        getLeaves(root1);
        checkLeaves(root2);
        return isSame;
    }
    
    private void getLeaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) leaves.add(root.val);
        getLeaves(root.left);
        getLeaves(root.right);
    }
    
    private void checkLeaves(TreeNode root) {
        if(!isSame) return;
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val != leaves.get(cur++)) isSame = false;
            return;
        }
        checkLeaves(root.left);
        checkLeaves(root.right);
    }
}