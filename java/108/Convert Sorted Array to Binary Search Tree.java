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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int low, int high)
    {
        if(low <= high && low >=0 && high < nums.length)
        {
            int mid = low + (high - low) / 2;
            TreeNode res = new TreeNode(nums[mid]);
            res.left = helper(nums, low, mid - 1);
            res.right = helper(nums, mid + 1, high);      
            return res;
        }
        return null;
    }
}