/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        helper(root, 0);
    }
    
    private void helper(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;
        set.add(val);
        helper(node.left, 2 * val + 1);
        helper(node.right, 2 * val + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */