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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        Map<Integer, Integer> val2InIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            val2InIndex.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return helper(postorder, val2InIndex, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, Map<Integer, Integer> val2InIndex, int beginInIndex, int endInIndex) {
        if (beginInIndex > endInIndex) return null;
        int val = postorder[postIndex--];
        TreeNode cur = new TreeNode(val);
        if (beginInIndex == endInIndex) return cur;
        int inIndex = val2InIndex.get(val);
        cur.right = helper(postorder, val2InIndex, inIndex + 1, endInIndex);
        cur.left = helper(postorder, val2InIndex, beginInIndex, inIndex - 1);
        return cur;
    }
}