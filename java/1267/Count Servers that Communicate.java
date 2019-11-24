class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[] rowSum = new int[m];
        int[] columnSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    rowSum[i]++;
                    columnSum[j]++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (rowSum[i] < 2 && columnSum[j] < 2) {
                        res--;
                    }
                }
            }
        }
        
        return res;
    }
}