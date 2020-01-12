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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        preOrder(root, false, false);
        return sum;
    }
    
    private void preOrder(TreeNode node, boolean hasEvenGrandParent, boolean hasEvenParent) {
        if (node != null) {
            if (hasEvenGrandParent) sum += node.val;
            preOrder(node.left, hasEvenParent, node.val % 2 == 0);
            preOrder(node.right, hasEvenParent, node.val % 2 == 0);
        }
    }
}