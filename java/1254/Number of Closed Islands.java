class Solution {
    public int closedIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    if (helper(grid, i , j)) res++;
                }
            }
        }
        return res;
    }
    
    private boolean helper(int[][] grid, int curI, int curJ) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        grid[curI][curJ] = 2;
        boolean res = true;
        for (int[] dir : dirs) {
            int newI = curI + dir[0], newJ = curJ + dir[1];
            if (newI == 0 || newI == m - 1 || newJ == 0 || newJ == n - 1) {
                if (grid[newI][newJ] == 0) res = false;
                continue;
            }
            if (grid[newI][newJ] == 2 || grid[newI][newJ] == 1) continue;
            if (!helper(grid, newI, newJ)) res = false;
        }
        return res;
    }
}