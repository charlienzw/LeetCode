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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    void helper(TreeNode cur, List<List<Integer>> res, int level) {
        if(cur == null) return;
        if(res.size() <= level) res.add(new ArrayList<>());
        List<Integer> temp = res.get(level);
        if(level % 2 == 0) temp.add(cur.val);
        else temp.add(0, cur.val);
        helper(cur.left, res, level + 1);
        helper(cur.right, res, level + 1);
    }
}