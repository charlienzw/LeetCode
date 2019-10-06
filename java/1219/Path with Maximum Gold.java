class Solution {
    int res = 0;
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(grid, i, j, visited, 0);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int curGold) {
        res = Math.max(res, curGold + grid[i][j]);
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || visited[ii][jj] || grid[ii][jj] == 0) continue;
            visited[ii][jj] = true;
            dfs(grid, ii, jj, visited, curGold + grid[i][j]);
            visited[ii][jj] = false;
        }
    }
}