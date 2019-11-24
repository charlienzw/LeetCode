class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp.add(grid[i][j]);
            }
        }
        
        int n = temp.size();
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = n - k % n; i < 2 * n - k % n; i++) {
            list.add(temp.get(i % n));
            if (list.size() == grid[0].length) {
                res.add(list);
                list = new ArrayList<>();
            }
        } 
        
        return res;
    }
}