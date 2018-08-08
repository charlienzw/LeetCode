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
        if(nums==null||nums.length==0) return null;
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int low,int high)
    {
        if(low>high) return null;
        if(low==high) return new TreeNode(nums[low]);
        int mid=(low+high)/2;
        TreeNode tn=new TreeNode(nums[mid]);
        tn.left=helper(nums,low,mid-1);
        tn.right=helper(nums,mid+1,high);
        return tn;
    }
}