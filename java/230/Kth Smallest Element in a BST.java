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
    int cnt = 1;
    Integer res = null;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }
    
    public void helper(TreeNode root, int k)
    {
        if(res != null) return;
        if(root != null)
        {
            helper(root.left, k);
            if(cnt == k)
            {
                res = new Integer(root.val);
            }
            cnt++;
            helper(root.right, k);
        }
    }
}