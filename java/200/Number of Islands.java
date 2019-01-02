// dfs is so direct
// Time: O(n) Space: O(n) n is the number of ‘1’
class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int d = 0; d < 4; d++)
        {
            dfs(grid, i + dir[d][0], j + dir[d][1]);
        }
    }
}



