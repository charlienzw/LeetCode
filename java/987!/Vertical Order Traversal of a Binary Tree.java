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
    class Location {
        int val;
        int row;
        int col;
        public Location(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Location> locations = new ArrayList<>();
        helper(root, 0, 0, locations);
        Collections.sort(locations, (a, b) -> (a.col != b.col ? a.col - b.col : (a.row != b.row ? a.row - b.row : (a.val - b.val))));
        List<List<Integer>> res = new ArrayList<>();
        Integer pre = null;
        for(int i = 0; i < locations.size(); i++) {
            Location curLocation = locations.get(i);
            if(pre == null || curLocation.col != pre) {
                pre = curLocation.col;
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(curLocation.val);
        }
        return res;
    }
    public void helper(TreeNode cur, int row, int col, List<Location> locations) {
        if(cur != null) {
            locations.add(new Location(cur.val, row, col));
            helper(cur.left, row + 1, col - 1, locations);
            helper(cur.right, row + 1, col + 1, locations);
        }
    }
    
}