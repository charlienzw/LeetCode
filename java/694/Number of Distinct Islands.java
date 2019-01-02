/*
Different figure island
Use hashset to eliminate distinct
The left-up position is first to be visited. So we can set the left-up position to the center for every island
test cases: [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","0","1","1"],["0","0","0","1","1"]] 1
[["0","1","1","0","0"],["1","1","0","0","0"],["0","0","0","1","1"],["0","0","1","1","0"]] 1
Time: O(m * n) Space: O(m * n) 
*/
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int res = 0;
        List<Integer> dirlist;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    dirlist = new ArrayList<>();
                    dfs(grid, i, j, -1, dirlist);
                    System.out.println(i + " " + j);
                    set.add(new ArrayList<>(dirlist));
                }
            }
        }
        return set.size();
    }
    public void dfs(int[][] grid, int i, int j, int dirnow, List<Integer> dirlist)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) 
        {
            return;
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dirlist.add(dirnow);
        grid[i][j] = 0;
        for(int d = 0; d < 4; d++)
        {
            dfs(grid, i + dir[d][0], j + dir[d][1], d, dirlist);
        }
        dirlist.add(-1);
    }
}