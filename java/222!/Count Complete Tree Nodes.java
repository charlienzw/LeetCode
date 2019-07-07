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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        TreeNode cur = root;
        int depth = 0;
        while (cur.left != null) {
            cur = cur.left;
            depth++;
        }
        if (depth == 0) return 1;
        
        int left = 1, right = (int)Math.pow(2, depth), mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (exist(mid, depth, root)) left = mid + 1;
            else right = mid;
        }
        
        return (int)Math.pow(2, depth) - 1 + right;
    }
    
    private boolean exist(int objMid, int depth, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;
        int mid;
        for(int i = 0; i < depth; ++i) {
          mid = left + (right - left) / 2;
          if (objMid <= mid) {
            node = node.left;
            right = mid;
          }
          else {
            node = node.right;
            left = mid + 1;
          }
        }
        return node != null;
    }
}