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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, sum, res, root.val, path);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> res, int curSum, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (curSum == sum) {
                res.add(new ArrayList<>(path));
                return;
            }
        }
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, sum, res, curSum + root.left.val, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, sum, res, curSum + root.right.val, path);
            path.remove(path.size() - 1);
        }
        
    }
}