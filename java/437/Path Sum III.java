//Time:O(nlogn)
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
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        helper(root, sum);
        return res;
    }
    public void helper(TreeNode root, int sum)
    {
        if(root != null)
        {
            search(root, sum, 0);
            helper(root.left,sum);
            helper(root.right,sum);
        }
    }
    public void search(TreeNode root, int sum, int plus)
    {
        if(root != null)
        {
            if(root.val + plus == sum) res++;
            search(root.left, sum, root.val + plus);
            search(root.right, sum, root.val + plus);
        }
    }
}