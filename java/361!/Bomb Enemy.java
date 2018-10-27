//Time: O(m*n)
//Space: O(m*n)
//DP in four directions
class Solution {
    class spot{
        public int up=0;
        public int down=0;
        public int left=0;
        public int right=0;
    }
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        int res = 0;
        spot[][] dp = new spot[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                dp[i][j] = new spot();
                if(grid[i][j] != 'W')
                {
                    dp[i][j].up = (i == 0 ? 0 : dp[i - 1][j].up) + (grid[i][j] == 'E' ? 1 : 0);
                    dp[i][j].left = (j == 0 ? 0 : dp[i][j - 1].left) + (grid[i][j] == 'E' ? 1 : 0);
                }
            }
        }
        for(int i = grid.length - 1; i >= 0; i--)
        {
            for(int j = grid[0].length - 1; j >= 0; j--)
            {
                if(grid[i][j] != 'W')
                {
                    dp[i][j].down = (i == grid.length - 1 ? 0 : dp[i + 1][j].down) + (grid[i][j] == 'E' ? 1 : 0);
                    dp[i][j].right = (j == grid[0].length - 1 ? 0 : dp[i][j + 1].right) + (grid[i][j] == 'E' ? 1 : 0);
                }
                if(grid[i][j] == '0')
                {
                    res = Math.max(res, dp[i][j].up + dp[i][j].down + dp[i][j].left + dp[i][j].right);
                }
            }
        }  
        return res;
    }
}