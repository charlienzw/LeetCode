/*
    Recursive Function design
        if beginInIndex > endInIndex
            The node should not be here. Return null.
        if beginInIndex == endInIndex
            The node is here. Don't need recursion again.
        if beginInIndex > endInIndex
            There should be more nodes in this branch.
    Time: O(n)
    Space: O(n)
*/

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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> val2InIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            val2InIndex.put(inorder[i], i);
        }
        return helper(preorder, val2InIndex, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, Map<Integer, Integer> val2InIndex, int beginInIndex, int endInIndex) {
        if (beginInIndex > endInIndex) return null;
        int val = preorder[preIndex++];
        TreeNode cur = new TreeNode(val);
        if (beginInIndex == endInIndex) return cur;
        int inIndex = val2InIndex.get(val);
        cur.left = helper(preorder, val2InIndex, beginInIndex, inIndex - 1);
        cur.right = helper(preorder, val2InIndex, inIndex + 1, endInIndex);
        return cur;
    }
}