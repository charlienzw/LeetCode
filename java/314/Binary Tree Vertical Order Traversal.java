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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root);
        cols.add(0);
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while(q.size() > 0) {
            TreeNode node = q.poll();
            int col = cols.poll();
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if(node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
            }
            if(node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}