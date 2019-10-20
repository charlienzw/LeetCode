/*
0 child: directly delete
1 child: delete and add as forest
2 child: delete and add as forests

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        List<TreeNode> res = new ArrayList<>();
        helper(root, set, res, null, true);
        return res;
    }
    
    private void helper(TreeNode cur, Set<Integer> set, List<TreeNode> res, TreeNode parent, boolean isLeft) {
        if (cur == null) return;
        if (set.contains(cur.val)) {
            if (parent != null) {
                if (isLeft) parent.left = null;
                else parent.right = null;
            }
            helper(cur.left, set, res, null, true);
            helper(cur.right, set, res, null, false);
        } else {
            if (parent == null) {
                res.add(cur);
            }
            helper(cur.left, set, res, cur, true);
            helper(cur.right, set, res, cur, false);
        }
    }
}